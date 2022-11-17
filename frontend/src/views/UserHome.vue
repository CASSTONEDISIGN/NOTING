<template>
  <div class="main">
    <v-col cols="12" sm="8" md="8">
      <v-card class="elevation-12">
        <v-window v-model="step">
          <v-window-item :value="1">
            <v-row>
              <v-col cols="12" md="8">
                <v-card-text class="mt-12">
                  <h1 class="text-center teal--text text--lighten-1">
                    Sign in to Noting
                  </h1>
                  <div class="text-center mt-4">
                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-google-plus-g</v-icon>
                    </v-btn>
                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-facebook-f</v-icon>
                    </v-btn>
                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-kaggle</v-icon>
                    </v-btn>
                  </div>
                  <h4 class="text-center mt-4">
                    다른 소셜 계정으로 계속하기
                  </h4>
                  <v-form>
                    <v-text-field
                      label="Email"
                      name="Email"
                      prepend-icon="email"
                      type="text"
                      color="teal lighten-1"
                    />

                    <v-text-field
                      id="password"
                      label="Password"
                      name="password"
                      prepend-icon="lock"
                      type="password"
                      color="teal lighten-1"
                    />
                  </v-form>
                  <h3 class="text-center mt-4">
                    비밀번호를 잊으셨나요 ?
                  </h3>
                </v-card-text>
                <div class="text-center mt-3">
                  <v-btn rounded color="teal lighten-1" dark @click="SignIn"
                    >SIGN IN</v-btn
                  >
                </div>
              </v-col>
              <v-col cols="12" md="4" class="teal lighten-1">
                <v-card-text class="white--text mt-12">
                  <h1 class="text-center">어서오세요!</h1>
                  <h5 class="text-center">
                    함께 손쉬운 웨이팅이 가능한 곳으로 떠나기
                  </h5>
                </v-card-text>
                <div class="text-center">
                  <v-btn rounded outlined dark @click="step++">SIGN UP</v-btn>
                </div>
              </v-col>
            </v-row>
          </v-window-item>
          <v-window-item :value="2">
            <v-row class="fill-height">
              <v-col cols="12" md="4" class="teal lighten-1">
                <v-card-text class="white--text mt-12">
                  <h1 class="text-center">WELCOME!</h1>
                  <h5 class="text-center">
                    계속하시려면 정보를 입력해주세요
                  </h5>
                </v-card-text>
                <div class="text-center">
                  <v-btn rounded outlined dark @click="step--">Sign in</v-btn>
                </div>
                <v-btn
                  class="market_btn"
                  rounded
                  outlined
                  dark
                  @click="MarketHome"
                  >Market</v-btn
                >
              </v-col>

              <v-col cols="12" md="8">
                <v-card-text class="mt-12">
                  <h1 class="text-center teal--text text--lighten-1">
                    Create Account
                  </h1>
                  <div class="text-center mt-4">
                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-google-plus-g</v-icon>
                    </v-btn>

                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-facebook-f</v-icon>
                    </v-btn>
                    <v-btn class="mx-2" fab color="black" outlined>
                      <v-icon>fab fa-kaggle</v-icon>
                    </v-btn>
                  </div>
                  <h4 class="text-center mt-4">
                    다른 소셜 계정으로 계속하기
                  </h4>
                  <v-form>
                    <v-text-field
                      label="name"
                      name="name"
                      v-model="name"
                      prepend-icon="person"
                      type="text"
                      color="teal lighten-1"
                    />
                    <v-text-field
                      label="email"
                      name="email"
                      v-model="email"
                      prepend-icon="email"
                      type="text"
                      color="teal lighten-1"
                    />

                    <v-text-field
                      
                      label="password"
                      name="password"
                      v-model="password"
                      prepend-icon="lock"
                      type="password"
                      color="teal lighten-1"
                    />
                  </v-form>
                </v-card-text>
                <div class="text-center mt-n5">
                  <v-btn rounded color="teal lighten-1" dark @click="SignUp"
                    >SIGN UP</v-btn
                  >
                </div>
              </v-col>
            </v-row>
          </v-window-item>
        </v-window>
      </v-card>
    </v-col>
  </div>
</template>

<script>
import { get__signin } from "../API/GET/get";
import { post__signup } from "../API/POST/post";
export default {
  data: () => ({
    step: 1,
    name: "",
    email: "",
    password: "",
  }),
  props: {
    source: String,
  },
  methods: {
    SignIn: function() {
      get__signin(this.email, this.password);
      // 로그인 성공 시 router push
      this.$router.push("/map");
    },

    SignUp: async function() {
      this.$router.push("/signup");
      const userData = {
        name: this.name,
        email: this.email,
        pw: this.password,
      };
      await post__signup(userData);
    },

    MarketHome: function() {
      this.$router.push("/market");
    },
  },
};
</script>

<style>
.main {
  display: flex;
  width: 146vw;
  padding-left: 1.2em;
}
::-webkit-scrollbar {
  display: none;
}

h1 {
  font-size: 3rem;
  font-family: "Alice-Regular", sans-serif !important;
  padding-bottom: 2rem;
}

.market_btn {
  position: absolute;
  top: 50%;
  left: 127px;
}
</style>
