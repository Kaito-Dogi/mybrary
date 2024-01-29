# https://github.com/e10dokup/CiSample/blob/feature/create_lint/Dangerfile

github.dismiss_out_of_range_messages

# android lint
Dir.glob("./lint/**/lint-*.xml").each { |report|
  # Lint only added/modified files
  android_lint.filtering = true

  # Already have lint xml, set true
  android_lint.skip_gradle_task = true

  android_lint.report_file = report.to_s

  # Show suggestion only above on this severity
  # android_lint.severity = "Error"

  # Fire ;-)
  android_lint.lint(inline_mode: true)
}

# test
Dir.glob("./test-results/**/*.xml").each { |report|
  junit.parse(report)
  junit.show_skipped_tests = true
  junit.report
}
