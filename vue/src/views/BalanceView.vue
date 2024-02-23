<template>
  <h2>View Balance</h2>
  <h3>UserName: {{ this.$store.state.user.username }}</h3>
  <p>Balance: {{this.$store.state.balance}} </p>
  <button @click="fetchBalance">Refresh Balance</button>

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

},
  mounted(){
    this.fetchBalance;
  }
  
}
</script>

<style scoped>

</style>