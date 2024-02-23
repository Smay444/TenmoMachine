<template>
  <h2>View Balance</h2>
  <p>Balance: {{ this.$store.state.balance }}</p>

</template>

<script>
export default {
  computed: {
    balance(){
      return this.$store.state.balance;
    }
  }
}
</script>

<style scoped>

</style>