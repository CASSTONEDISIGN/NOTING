import axios from "axios";
import { API_URL } from "../../../env";
import hashing from "../../hashing";

export const post__signup = async ({ name, id, pw }) => {
  // regex
  // 2~ 10자의 영문자, 한글, 숫자 가능
  const RegexName = /^(?=.*[a-zA-Z\dㄱ-ㅎㅏ-ㅣ가-힣])[A-Za-z\dㄱ-ㅎㅏ-ㅣ가-힣]{2,10}$/gi;
  // ID가 E-mail이기에 email 양식을 따름
  const RegexId = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
  // 8~ 16자의 영문자 숫자, 특수문자 가능
  const RegexPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%&*?])[A-Za-z\d@!@#$%&*?]{8,16}$/;

  const isConfirmName = RegexName.test(name);
  const isConfirmId = RegexId.test(id);
  const isConfirmPw = RegexPw.test(pw);

  if (isConfirmName && isConfirmPw && isConfirmId) {
    console.log("정규표현식이 만족합니다.");
    try {
      const hashing_pw = hashing(pw);
      const res = await axios.post(`${API_URL}/signup`, {
        name,
        id,
        pw: hashing_pw,
      });
      console.log(res);
      return res;
    } catch (err) {
      console.error(err);
    }
  } else {
    console.log("정규표현식이 만족하지 않습니다.");
  }
};
