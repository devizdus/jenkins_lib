def generate_slack_message() {
    message_rows = [
        "*${currentBuild.currentResult}:* ${BUILD_TAG} (<$BUILD_URL|Open>)",
        "Duration: ${currentBuild.durationString}",
        "Branch: ${env.BRANCH}",
        "Test environment: ${env.TEST_ENVIRONMENT}",
        "Test suit: ${env.SUITE_NAME}",
        "See the detailed report <${env.BUILD_URL}/allure|here>",
    ]

    return message_rows.join("\n")
}