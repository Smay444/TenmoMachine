<template>
  <h2>View Balance</h2>
  <p>Balance: {{ balance }}</p>

</template>

<script>
export default {
  computed: {
    balance(){
      return this.$store.getters.getBalance;
    }
  }
}
</script>

<style scoped>

</style>