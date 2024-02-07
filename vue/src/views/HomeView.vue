<template>
 
  <div class="home">
    <h1>Tenmo Money Transfer System</h1>
      <div id="buttons">
        <button>View Balance</button>
        <button>View Transactions</button>
        <button>View Pending Transactions</button>
        <button>Send Tenmo Bucks</button>
        <button>Exit</button>
      </div>

    
  </div>
</template>

<script>

export default {
  components: {
   
  },
  data(){
    return{
      users: [],
    }
  }



};
</script>

<style scoped>
  h1{
    color: purple;
    text-align: center;
    border: 3px solid gray;
    border-radius: 25px;
    background-color: lightgray;
  }
  #buttons{
    display: flex;
    flex-direction: column;
    align-items: center;

  }
</style>

