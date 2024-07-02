import requests
import os
import json
from openai import OpenAI

# 環境変数を初期化
GITHUB_TOKEN = os.getenv('GITHUB_TOKEN')
OPENAI_API_KEY = os.getenv('OPENAI_API_KEY')
GPT_MODEL = os.getenv('GPT_MODEL')
GPT_REVIEW_PROMPT = os.getenv('GPT_REVIEW_PROMPT')
GPT_SYSTEM_PROMPT = os.getenv('GPT_SYSTEM_PROMPT')
REPOSITORY = os.getenv('REPOSITORY')
PR_NUMBER = int(os.getenv('PR_NUMBER'))
PR_API_URL = f'https://api.github.com/repos/{REPOSITORY}/pulls/{PR_NUMBER}'

# PR の diff を取得する
def get_pr_diff():
  headers = {
    'Authorization': f'token {GITHUB_TOKEN}',
    'Accept': 'application/vnd.github.v3.diff'
  }
  diff_response = requests.get(PR_API_URL, headers=headers)
  diff_text = diff_response.text

  # デバッグのために diff を出力
  print('あああ: ', diff_text)

  return diff_text

# コードレビューを依頼するプロンプトを作成
def create_review_prompt(code_diff):
  prompt = f'Review the following code:\n\n{code_diff}\n\n{GPT_REVIEW_PROMPT}'
  prompt += create_ignore_reviews_prompt()
  return prompt

# 既にされているコメントと同じコメントをしないよう依頼するプロンプトを作成
def create_ignore_reviews_prompt():
  url = f'{PR_API_URL}/comments'
  headers = {'Authorization': f'token {GITHUB_TOKEN}'}
  response = requests.get(url, headers=headers)
  comments = response.json()
  if len(comments) == 0:
    return ""
  ignore_prompt = '- However, please ensure the content does not duplicate the following existing comments:\n'
  for comment in comments:
    body = comment['body']
    path = comment.get('path')
    line = comment.get('line') or comment.get('original_line')
    ignore_prompt += f'  - file "{path}", line {line}: {body}\n'
  return ignore_prompt

# Open AI API でコードレビューを行い、結果を json で取得する
def get_gpt_review(prompt):
  client = OpenAI(api_key=OPENAI_API_KEY)
  chat_completion = client.chat.completions.create(
    messages=[
      {
        'role' : 'system',
        'content': GPT_SYSTEM_PROMPT
      },
      {
        'role': 'user',
        'content': prompt,
      }
    ],
    response_format={'type':'json_object'},
    model=GPT_MODEL,
  )

  # デバッグのために GPT からのレスポンスを出力
  print('あああ: ', chat_completion)

  review_result = chat_completion.choices[0].message.content
  return review_result

# レビューコメントを投稿する
def post_review_comments(review_files):
  url = f'{PR_API_URL}/commits'
  headers = {
    'Authorization': f'token {GITHUB_TOKEN}',
    'Accept': 'application/vnd.github.v3+json'
  }
  pr_commits_response = requests.get(url, headers=headers)
  pr_commits = pr_commits_response.json()
  last_commit = pr_commits[-1]['sha']
  for file in review_files['files']:
    for review in file['reviews']:
      comment_url = f'{PR_API_URL}/comments'
      comment_data = {
        'body': review['reviewComment'],
        'commit_id': last_commit,
        'path': file['fileName'],
        'position': review['lineNumber']
      }
      requests.post(comment_url, headers=headers, data=json.dumps(comment_data))

code_diff = get_pr_diff()
prompt = create_review_prompt(code_diff)
review_result = get_gpt_review(prompt)
post_review_comments(json.loads(review_result))
