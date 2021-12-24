<template>
  <div id="app">
    <HttpCommunication/>
  </div>
</template>

<script>
import HttpCommunication from './components/HttpCommunication.vue'

export default {
  name: 'App',
  components: {
    HttpCommunication
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  display: flex;
  justify-content: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
