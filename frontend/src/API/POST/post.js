import axios from "axios";
import hashing from "../hashing";
import { API_URL } from "../../env";

export const post__signup = async ({ name, email, pw }) => {
  // regex
  // 2~ 10자의 영문자, 한글, 숫자 가능
  const RegexName = /^(?=.*[a-zA-Z\dㄱ-ㅎㅏ-ㅣ가-힣])[A-Za-z\dㄱ-ㅎㅏ-ㅣ가-힣]{2,10}$/gi;
  // email 양식
  const RegexEmail = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
  // 8~ 16자의 대소문자 구분, 영문자 하나 이상, 숫자 하나 이상, 특수문자 하나 이상
  const RegexPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%&*?])[A-Za-z\d@!@#$%&*?]{8,16}$/;

  const isConfirmName = RegexName.test(name);
  const isConfirmEmail = RegexEmail.test(email);
  const isConfirmPw = RegexPw.test(pw);

  if (isConfirmName && isConfirmEmail && isConfirmPw) {
    console.log("정규표현식이 만족합니다.");
    try {
      const hashing_pw = hashing(pw);
      const res = await axios.post(
        `${API_URL}/signup`,
        {
          "name": name,
          "email": email,
          "pw": hashing_pw,
        },
        {
          headers: {
            "Content-Type": `application/json`,
          },
        }
      );
      console.log(res);
      return res;
    } catch (err) {
      console.error(err);
    }
  } else {
    console.log("정규표현식이 만족하지 않습니다.");
    console.log(name, email, pw);
    console.log(`isConfirmName: ${isConfirmName}`);
    console.log(`isConfirmEmail: ${isConfirmEmail}`);
    console.log(`isConfirmPassword: ${isConfirmPw}`);
  }
};
