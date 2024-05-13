<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
</script>

<!-- RouterLink : 등록된 Router의 링크를 만들어주는 역할
  Route (경로 -> 어디로 가야하는가에 대한 정보)를 등록
  => 따라서 RouterLink의 to 속성에는 Route에 대한 정보가 Mapping되어 있어야 한다. 
  => RouterLink에 어디로 가서 Component를 가져와야 하는 지에 대한 정보가 있음
  => 그리고 해당 화면 Component를 가져온 결과가 나타나는 곳이 RouterView다
  => http://localhost:9000/ => 바로 켜지면 '/'를 입력되는 것과 같으므로 바로 HomeView가 켜지는 것이다.
  => RouterLink를 누르면, 해당 Route의 정보를 찾으며 URL로 경로가 나타난다. => History 관리 되서, 뒤로가기도 가능하다!
  => 경로에 해당하는 Route 정보가 없다면, 빈 화면을 보여줄 뿐이다. ( 없기 때문에 )
-->

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="Ver4. Router & Axios" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
        <router-link to="/dept">Dept</router-link>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
