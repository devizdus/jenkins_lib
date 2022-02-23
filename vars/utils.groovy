def notify_to_slack(String chanel, String message, Boolean disabled = false) {
    if (!disabled) {
        SLACK_COLOR_MAP = [
                'SUCCESS': 'good',
                'FAILURE': 'danger',
                'UNSTABLE': 'danger',
        ]

        slackSend(
            channel: chanel,
            message: message,
            color: SLACK_COLOR_MAP[currentBuild.currentResult]
        )
    }
}


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


def info(message) {
    echo "INFO: ${message}"
}