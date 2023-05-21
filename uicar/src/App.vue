<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <FiltroCars/>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import FiltroCars from './components/FiltroCars.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    FiltroCars
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
