import http from "k6/http";
import { check, sleep } from "k6";
import encoding from "k6/encoding";

var username = "dev";
var password = "devpass01";

const credentials = `${username}:${password}`;
const encodedCredentials = encoding.b64encode(credentials);
const basicParams = {
  headers: {
    Authorization: `Basic ${encodedCredentials}`,
  },
};
const ambiente = "http://localhost:5000";

export const options = {
  discardResponseBodies: true,
  scenarios: {
    contacts: {
      executor: "constant-arrival-rate",

      duration: "3m",
      rate: 3000,
      timeUnit: "1m",
      preAllocatedVUs: 50,
      maxVUs: 100,
    },
  },
};

export default function () {
  const featureID = "showRestApiURL";
  const res = http.get(
    `${ambiente}/feature--toggle/api/ff4j/store/features/${featureID}`,
    basicParams
  );

  check(res, {
    "o status é 200": (r) => r.status === 200,
  });

  if (res.status != 200) {
    console.log(res.status);
  }
}
