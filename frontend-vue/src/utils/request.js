import axios from 'axios'

const request = axios.create({
    baseURL: "api",
    timeout: 5000
})

request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    return config
}, error => {
    return Promise.reject(error)
});

request.interceptors.response.use(
    response => {
        let resData = response.data;
        if(response.config.responseType === 'blob') {
            return resData;
        }
        if(typeof resData === 'string'){
            resData = resData ? JSON.parse(resData):resData
        }
        return resData;
    },
    error => {
        console.log('err' + error)
        return Promise.reject(error)
    }
)

export default request