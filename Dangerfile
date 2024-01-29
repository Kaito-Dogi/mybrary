github.dismiss_out_of_range_messages

Dir.glob("./test-results/**/*.xml").each { |report|
  junit.parse(report)
  junit.show_skipped_tests = true
  junit.report
}
