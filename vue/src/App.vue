<template>

  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    
    </div>
    <router-view />


    <footer>© Tenmo Money Transfer System</footer>
  </div>
</template>

<style scoped>
footer{
  margin: 20px;
  padding: 5px;
  
}
</style>
