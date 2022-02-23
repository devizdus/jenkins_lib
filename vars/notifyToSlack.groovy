def call(Map config) {

    String chanel = config.get('chanel', null)
    Boolean disabled = config.get('disabled', false).toBoolean()
    String mesasge = config.get('message', generate_message())

    RESULT_COLOR_MAP = [
        'SUCCESS': 'good',
        'FAILURE': 'danger',
        'UNSTABLE': 'danger',
    ]

    if (!chanel) {
        error("Missing argument: chanel")
    }

    if (!disabled) {
        slackSend(
            channel: chanel,
            message: message,
            color: RESULT_COLOR_MAP[currentBuild.currentResult]
        )
    }
}


def generate_message() {
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
