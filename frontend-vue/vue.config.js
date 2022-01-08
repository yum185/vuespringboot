module.exports = {
    devServer: {
        port: 9876,
        proxy: {
            '/api': {
                target: 'http://localhost:8089',
                changeOrigin: true,
                pathRewrite: {
                    '/api': ''
                }
            }
        }
    }
}