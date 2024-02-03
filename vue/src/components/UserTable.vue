<template>
    <div>
         <button class="button">Request Transfer</button>
         <button class="button">Send Money</button>
         <button class="button">Approve Transfer</button>
         <button class="button">Get Your Transactions</button>
    </div>
    <div class="directory">
        <h2>Users Directory</h2>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input v-model="filter.userId" type="text" id="userId">
                        </td>
                        <td>
                            <input v-model="filter.username" type="text" id="username">
                        </td>
                    </tr>
                    <tr v-for="user in filteredList" v-bind:key="user.userId" v-bind:user="users">
                        <td>{{ user.id }}</td>
                        <td>{{ user.username }}</td>
                        <td >
                            <button class="action">Send</button>
                            <button class="action">Request</button>
                        </td>
                    </tr>
                
                </tbody>

            </table>
        </div>

    </div>
</template>

<script>
import UserService from '../services/UserService'
export default {
    data() {
        return {
            user: [],
            filter: {
                userId: "",
                username: "",
            }
        }
    },
    created() {
        this.refresh();
    },
    computed: {
        users() {
            return this.$store.state.users;
        },
        filteredList() {
            let filteredUsers = this.$store.state.users;

            if (this.filter.userId !== "") {
                filteredUsers = filteredUsers.filter((user) =>
                    user.id.toString().includes(this.filter.userId.toString())
                );
            }
            if (this.filter.username !== "") {
                filteredUsers = filteredUsers.filter((user) =>
                    user.username.toLowerCase().includes(this.filter.username.toLowerCase())
                );
            }
            return filteredUsers;
        }
    },
    methods: {
        refresh() {
            UserService.getUsers().then(
                (response) => {
                    this.$store.commit("SET_USERS", response.data)
                }
            )
        }
    }
}
</script>

<style>
.button,.action{
    display: inline-block;
    padding: 5px;
    margin: 5px;
    color: purple;
    border-radius: 25px;
    border: .1em gray solid;
    transition: background-color 0.3s, color 0.3s;
   
}
.button:hover, .action:hover{
    background-color: purple;
    color: white;
}
.directory{
    display: flex;
    flex-direction: column;
    text-align: center;
    border: 2px black solid;
}
tr,td{
    padding: 2px;
    border: 1px gray solid;
}
body{
    background-color: rgb(158, 151, 168);
    
}
th{
    text-decoration: underline;
}
h2{
    display: block;
    width: 0 auto;
    text-align: center;
    color: rgb(73, 17, 73)
    

}
</style>