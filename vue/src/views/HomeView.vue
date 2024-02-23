<template>
  <div class="home">
    <h1>Tenmo Money Transfer System</h1>
    <div id="buttons">
      <button @click="navigateToBalanceView">View Balance</button>
      <button @click="navigateToTransactionView">View Transactions</button>
      <button @click="navigateToPendingView">View Pending Transactions</button>
      <button @click="navigateToSendView">Send Tenmo Bucks</button>
      <button @click="navigateToRequestView">Request Tenmo Bucks</button>
      <button @click="navigateToHomeView">Logout</button>
    </div>


  </div>
</template>

<script>
import { useRouter } from 'vue-router';
export default {
  setup() {
    const router = useRouter();

    const navigateToBalanceView = () => {
      router.push('/balance')
    };

    const navigateToTransactionView = () => {
      router.push("/transaction")
    };

    const navigateToPendingView = () => {
      router.push("/pending")
    };

    const navigateToSendView = () => {
      router.push("/send")
    };

    const navigateToHomeView = () => {
      router.push("/logout")
    };

    const navigateToRequestView = () => {
        router.push("/request");
    }


    return {
      navigateToBalanceView,
      navigateToTransactionView,
      navigateToPendingView,
      navigateToSendView,
      navigateToHomeView,
      navigateToRequestView
    }
  }
};
</script>

<style scoped>
h1 {
  color: purple;
  text-align: center;
  border: 3px solid gray;
  border-radius: 25px;
  background-color: rgb(211, 211, 211);
}

#buttons {
  display: grid;
  place-items: center;
  /* Horizontally and vertically centers buttons */
}

button {
  box-shadow: 5px 5px purple;
  align-items: center;
  border-radius: 25px;
  margin: 15px 0 auto;
  height: 25px;
  width: 250px;
  justify-content: center;
  /* Horizontally centers buttons */
}
</style>

