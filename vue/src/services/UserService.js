import axios from 'axios';

export default {
    getUsers(){
        const url = '/transaction/list_users'
        return axios.get(url)
    },
    getUserById(id){
        const url = '/account' + id;

    },
}