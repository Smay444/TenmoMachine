import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      users: [],
      balance: 0
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        state.balance = user.balance;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_USERS(state, users){
        state.users = users;
      }, 
      SET_BALANCE(state, balance){
        state.balance = balance;
      }
    },
    export: {
      async fetchBalance({ commit, state }) {
        try {
          const userId = state.user.id; 
          const response = await axios.get(`/account/balance?userId=${userId}`);
          commit('SET_BALANCE', response.data); 
        } catch (error) {
         
          console.error('Error fetching balance:', error);
        }
      },
    }
    
  });
 
  return store;
}
