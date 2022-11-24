import axios from "axios";
import hashing from "../hashing";
import { API_URL } from "../../env";

export const get__signin = async (email, pw) => {
  try {
    const hashing_pw = hashing(pw);
    const res = await axios.get(
      `${API_URL}/signin?email=${email}&pw=${hashing_pw}`
    );
    return res;
  } catch (e) {
    return e;
  }
};

export const get__place = async (level, lat, lon) => {
  try {
    const res = await axios.get(
      `${API_URL}/map?level=${level}&x=${lon}&y=${lat}`
    );
    return res;
  } catch (e) {
    return e;
  }
};

export const get__place__name = async (level, place_name) => {
  try {
    const res = await axios.get(
      `${API_URL}/map?level=${level}&place_name=${place_name}`
    );
    return res;
  } catch (e) {
    return e;
  }
};
