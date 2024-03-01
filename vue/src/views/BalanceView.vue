<template>
  <h2>View Balance</h2>
  <h3>UserName: {{ this.$store.state.user.username }}</h3>
  <p>Balance: {{balance}} </p>
  <button @click="fetchBalance">Refresh Balance</button>
  <button @click="navigateToHomeView">Go Back Home</button>

</template>

<script>
import {mapActions} from 'vuex';
export default {
  computed: {
    balance(){
      return this.$store.state.balance;
    },
  },
  methods: {
    ...mapActions(['fetchBalance']),
    navigateToHomeView() {
      this.$router.push('/home');
    },

navigateToHomeView() {
  this.$router.push('/home');
},

mounted(){
  this.fetchBalance();
},
  

  
  
}
}

</script>

<style scoped>

</style>