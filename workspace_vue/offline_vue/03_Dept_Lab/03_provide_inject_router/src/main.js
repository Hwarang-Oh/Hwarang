import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'
// BootStrap을 npm을 설치한다고 해서, 이와 관려된 import code는 작성되지 않는다.
// 설정 code를 작성해주는 것은 처음에 project 만들 때만 해당된다.

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(router)
// App 어디에서도, router를 쓸 수 있게 등록해주고 있다

app.mount('#app')
