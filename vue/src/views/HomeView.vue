<template>
 
  <div class="home">
    <h1>Tenmo Money Transfer System</h1>

    <UserTable></UserTable>
  </div>
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
  h1{
    color: purple;
    text-align: center;
    border: 3px solid gray;
    border-radius: 25px;
    background-color: lightgray;
  }
</style>

