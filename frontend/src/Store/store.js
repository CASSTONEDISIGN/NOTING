import { createStore } from "vuex";

// Create a new store instance.
const store = createStore({
  state() {
    return {
      account: {
        id: 0,
      }
    };
  },
  mutations: {
    setAccount(state, payload){
      state.account.id = payload;
    }
  },
});

export default store;
