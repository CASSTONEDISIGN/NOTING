<template>
  <div class="container">
    <div style="display: flex">
      <div
        style="
          text-align: left;
          padding: 5px 30px 5px 15px;
          color: #ffbb00;
          font-size: 48px;
          font-weight: bold;
        "
      >
        가게 이름
      </div>
      <h1>채팅방</h1>
    </div>

    <h2 style="color: #5e6b5e">현재 대기 중인 팀 수 : 4</h2>
    <div id="chatting" class="chatting" style="display: flex;">
      <div class="team" v-if="chatOn">2팀</div>
      <div class="other" v-if="chatOn">안녕하세요</div>
      
      <div class="mine" v-if="mychatOn">반갑습니다</div>
      <div class="myteam" v-if="mychatOn">나</div>
    </div>

    <div style="display: flex">
      <v-text-field
        style="padding-right: 40px; font-size: large"
        @keydown.enter="send"
      ></v-text-field>
      <v-btn
        style="
          background-color: #ffbb00;
          position: absolute;
          bottom: 6.3%;
          right: 9%;
          font-size: large;
        "
        @click="mychat"
        >전송</v-btn
      >
    </div>
  </div>
</template>
<script>
export default {
  data: () => ({
    chat: "안녕하세요",
    chatOn: false,
    mychatOn: false,
  }),
  methods: {
    send() {
      setTimeout(() => {
        this.chatOn = true;
      }, 2000);
    },
    mychat() {
      this.mychatOn = true;
    },
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
.container {
  width: 500px;
  margin: 0 auto;
  padding: 25px;
}
.team {
  text-align: left;
  max-width: fit-content;
  font-size: 26px;
  padding: 0px 20px 0px 10px;
  margin-top: 30px;
}
.other {
  text-align: left;
  max-width: fit-content;
  padding: 0px 20px 0px 20px;
  border: #92dc1c 4px solid;
  border-radius: 14px 14px 14px 0%;
  margin-bottom: 427px;
}
.myteam{
  text-align: right;
  max-width: fit-content;
  font-size: 26px;
  padding: 0px 20px 0px 10px;
  margin-top: 140px;
}
.mine{
  text-align: right;
  max-width: fit-content;
  padding: 0px 20px 0px 20px;
  border: #92dc1c 4px solid;
  border-radius: 14px 14px 0% 14px;
  margin-top: 100px;
  margin-bottom: 327px;
}
.container h1 {
  text-align: left;
  padding: 5px 5px 5px 30px;
  color: #ffbb00;
  border-left: 3px solid #ffbb00;
  margin-bottom: 20px;
}
.chatting {
  background-color: rgb(255, 255, 255);
  text-align: right;
  padding: 12px;
  font-size: 25px;
  color: #92dc1c;
  width: 500px;
  height: 500px;
  overflow: auto;
}
input {
  width: 330px;
  height: 25px;
}
</style>
