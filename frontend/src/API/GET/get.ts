import axios, {AxiosError} from "axios";
import hashing from "../hashing";
import { API_URL } from "../../env";

export const get__signin = async (id, pw) => {
    try {
      const hashing_pw = hashing(pw);
      const res = await axios.get(`${API_URL}/signin?id=${id}&pw=${hashing_pw}`);
      return res;
    } catch (e: any) {
      const axiosError: AxiosError = e;
      return axiosError;
    }
  };