<template>
  <v-form ref="form" v-model="valid" lazy-validation>
    <p class="waiting_team">
      현재 대기 중인 팀 수 :
      <span style="margin-left: 30px; color: black">3</span>
    </p>
    <v-text-field
      v-model="name"
      :counter="10"
      :rules="nameRules"
      label="이름"
      required
      class="content"
    ></v-text-field>

    <v-select
      v-model="select"
      :items="items"
      :rules="[(v) => !!v || '인원 수를 선택해 주세요']"
      label="인원 수"
      required
      class="content label-h6"
    ></v-select>

    <v-text-field
      v-model="tel"
      :rules="telRules"
      label="전화번호"
      class="content"
      required
    ></v-text-field>

    <v-checkbox
      v-model="checkbox"
      :rules="[(v) => !!v || '동의를 해주셔야 다음 단계로 넘어갈 수 있습니다!']"
      label="개인정보 수집에 동의하시겠습니까?"
      required
      class="content"
    ></v-checkbox>

    <div
      style="display: flex; align-items: center; justify-content: space-around"
    >
      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
        style="font-size: x-large"
      >
        예약
      </v-btn>

      <v-btn
        color="error"
        class="mr-4"
        @click="reset"
        style="font-size: x-large"
      >
        취소
      </v-btn>
    </div>
  </v-form>
</template>
<script>
export default {
  data: () => ({
    valid: true,
    name: "",
    nameRules: [
      (v) => !!v || "이름을 입력해주세요.",
      (v) => (v && v.length <= 10) || "10글자 이내로 입력해주세요.",
    ],
    telRules: [
      (v) => !!v || "전화번호를 입력해주세요.",
      (v) => !!/^[0-9]+$/.test(v) || "숫자만 입력해주세요.",
    ],
    select: null,
    items: ["1명", "2명", "3명", "4명"],
    checkbox: false,
  }),

  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.$router.push("/slide3");
      }
    },
    reset() {
      this.$refs.form.reset();
    },
  },
};
</script>
<style>
.waiting_team {
  justify-content: center;
  display: flex;
  align-items: center;
  color: rgb(92, 158, 109);
  font-weight: 600;
  font-size: 60px;
}

.content {
  margin-bottom: 30px;
  font-weight: 600;
  min-height: 100px;
}
</style>
