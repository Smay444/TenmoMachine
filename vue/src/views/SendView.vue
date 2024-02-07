<template>
  <h2>Send Tenmo Bucks</h2>
  <user-table></user-table>

</template>

<script>
import UserTable from '../components/UserTable.vue'
export default {
  components: {
    UserTable,
  },
  data(){
    return{
      users: [],
    }
  }

};
</script>

<style>

</style>