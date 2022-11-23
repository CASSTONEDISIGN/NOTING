import { createStore } from "vuex";

// Create a new store instance.
const store = createStore({
  state() {
    return {
      account: {
        id: null,
        name: "허강민",
      }
    };
  },
  mutations: {
    setAccount(state, payload){
      state.account.id = payload.id;
      state.account.name = payload.name;
    }
  },
});

export default store;
