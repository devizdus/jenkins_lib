def call(String chanel, String message, Boolean disabled = false) {
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
