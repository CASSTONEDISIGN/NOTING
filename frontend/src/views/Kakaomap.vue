<template>
  <div>
    <div id="map">
      <!-- Side Bar -->
      <v-card class="sidebar">
        <!-- 로그인한 유저 정보 -->
        <v-list class="userInfo">
          <v-list-item class="profile">
            <v-img
              max-width="80px"
              src="https://randomuser.me/api/portraits/men/90.jpg"
            ></v-img>

            <v-list-item class="name">
              {{ store.state.account.name }}
            </v-list-item>
          </v-list-item>

          <v-list-item link class="infoOption" @click="toggleFold()">
            <v-icon color="white">mdi-magnify</v-icon>
            <h3>검색</h3>
          </v-list-item>

          <v-list-item link class="infoOption">
            <v-icon color="white">mdi-star</v-icon>
            <h3>북마크</h3>
          </v-list-item>

          <v-list-item link class="infoOption">
            <v-icon color="white">mdi-comment-multiple-outline</v-icon>
            <h3>채팅방</h3>
          </v-list-item>
          <v-list-item link class="infoOption">
            <v-icon color="white">mdi-bell-ring-outline</v-icon>
            <h3>알림</h3>
          </v-list-item>

          <v-list-item link class="infoOption">
            <v-icon color="white">mdi-view-headline</v-icon>
            <h3>더보기</h3>
          </v-list-item>
        </v-list>

        <!-- 맵 중앙을 중심으로 가게 정보 표기-->
        <v-card :class="isOpen ? 'showSidebar' : 'hideSidebar'">
          <v-toolbar dense extended extension-height="8" height="78px" >
            <v-text-field
              label="장소, 주소 검색"
              hide-details
              append-icon="search"
              single-line
              @keydown.enter="searchPlace"
              height="40px"
              padding-top="24px"
            ></v-text-field>
          </v-toolbar>
          <v-list-item>
            <v-list-item-content class="place_list">
              <div
                style="
                  justify-content: center;
                  padding: 10px;
                  color: #00635b;
                  font-size: 28px;
                  background-color: rgb(206 233 233);
                  margin-bottom: 20px;
                "
              >
                <v-icon x-large color="teal"> mdi-volume-high </v-icon>
                업데이트 안내
              </div>
              <div style="margin-bottom: 20px">
                <h2>충주시 대소원면</h2>
              </div>
              <div style="display: flex; gap: 1px; margin-bottom: 567px">
                <v-icon x-large color="orange">mdi-white-balance-sunny</v-icon>
                <h2
                  style="
                    padding-top: 8px;
                    padding-left: 8px;
                    padding-right: 8px;
                  "
                >
                  /
                </h2>
                <v-icon x-large color="orange">mdi-white-balance-sunny</v-icon>
                <h2
                  style="padding-top: 5px; padding-left: 200px; font-size: 27px"
                >
                  5
                </h2>
                <v-icon large>mdi-temperature-celsius</v-icon>
                <h2 style="padding-top: 8px; padding-left: 8px">/</h2>
                <h2
                  style="padding-top: 5px; padding-left: 8px; font-size: 27px"
                >
                  10
                </h2>
                <v-icon large>mdi-temperature-celsius</v-icon>
              </div>
              <div style="position: absolute; left: 23px; top: 212px">AM</div>
              <div style="position: absolute; left: 92px; top: 212px">PM</div>
              <div
                style="
                  position: absolute;
                  left: 14px;
                  top: 287px;
                  font-size: 30px;
                  color: #00635b;
                "
              >
                추천
              </div>
              <div style="position: absolute; left: 14px; top: 340px">
                <img src="../../src/assets/wkdtnrhf.jpg" width="460px" alt="" />
              </div>
              <div style="overflow: scroll">
                <h2
                  style="
                    position: absolute;
                    left: 10px;
                    top: 670px;
                    color: rgb(20 177 164);
                  "
                >
                  장수골
                </h2>
                <h3 style="position: absolute; left: 92px; top: 676px">한식</h3>
                <div
                  style="
                    position: absolute;
                    left: 380px;
                    top: 666px;
                    font-size: x-large;
                  "
                >
                  <v-icon color="red" x-large>mdi-star</v-icon> 4.65
                </div>
                <div
                  style="
                    position: absolute;
                    left: 13px;
                    top: 718px;
                    font-size: 19px;
                  "
                >
                  충북 충주시 대소원면 쇠실로 984
                </div>
                <div style="position: absolute; top: 808px">
                  <img
                    src="../../src/assets/rltktlrekd.jpg"
                    width="460px"
                    alt=""
                  />
                </div>
              </div>
            </v-list-item-content>
            <!-- <v-list-item-content
              v-for="rs in search.results"
              :key="rs.id"
              class="place_list"
            >
              <v-list-item-title class="text-h2">
                {{ rs.place_name }}
              </v-list-item-title>
            </v-list-item-content> -->
          </v-list-item>
          <button class="fold_button" @click="toggleFold()">
            <v-icon>mdi-menu-left</v-icon>
          </button>
        </v-card>
      </v-card>

      <!--  /Side Bar  -->

      <!-- Map Option Button -->
      <div class="searchPlaceNow">
        <!-- <button @click="searchPlaceNow"> -->
        <button @click="displayMarker(markerPositions3)">
          <v-icon color="white" x-large>mdi-reload</v-icon>
          현위치에서 다시 검색
        </button>
      </div>
      <div class="zoom-button">
        <button @click="currentPos" class="controll_btn">
          <v-icon color="white" x-large>mdi-crosshairs-gps</v-icon>
        </button>
        <button @click="zoomIn" class="controll_btn">
          <v-icon color="white" x-large>fa-plus</v-icon>
        </button>
        <button @click="zoomOut" class="controll_btn">
          <v-icon color="white" x-large>fa-minus</v-icon>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import store from "../Store/store";
// import get__place from "../API/GET/get";
import get__place__name from "../API/GET/get";

export default {
  data() {
    return {
      store: store,
      markerPositions1: [
        [33.452278, 126.567803],
        [33.452671, 126.574792],
        [33.451744, 126.572441],
      ],
      markerPositions2: [
        [37.499590490909185, 127.0263723554437],
        [37.499427948430814, 127.02794423197847],
        [37.498553760499505, 127.02882598822454],
        [37.497625593121384, 127.02935713582038],
        [37.49629291770947, 127.02587362608637],
        [37.49754540521486, 127.02546694890695],
        [37.49646391248451, 127.02675574250912],
      ],
      markerPositions3: [
        [36.96475796179156, 127.87092962031538],
        [36.9645887850697, 127.871427379772],
        [36.9634423299284, 127.871101030708],
        [36.96317635031259, 127.87026370742193],
        [36.9652272187733, 127.871852375899],
        [36.9650646899668, 127.870916271018],
        [36.963962986068, 127.871245077327],
        [36.9645750285612, 127.871337391682],
        [36.963994696407, 127.871344252354],
        [36.9634914836494, 127.870664792256],
        [36.9637939307276, 127.87119823568],
        [36.96395032286666, 127.87125167031604],
        [36.9635823347936, 127.870686038623],
        [36.9647286149388, 127.870913565497],
        [36.9650521256159, 127.8709093905],
        [36.96408901216124, 127.87077041062898],
        [36.9633692133337, 127.870627467931],
        [36.96395389384447, 127.87125620253748],
        [36.9644269047346, 127.871385110643],
        [36.9638769728943, 127.870687148229],
        [36.965232366756375, 127.871764848347],
        [36.96505363108254, 127.87094983198573],
        [36.96522031928057, 127.87156483466491],
        [36.9638552834197, 127.870695884271],
        [36.9651981013861, 127.870908807595],
        [36.9648762114907, 127.87093770475671],
        [36.9648883607757, 127.870878329683],
        [36.96453991561552, 127.87071940163963],
        [36.96435856606099, 127.87087454060834],
        [36.9650572963569, 127.871432719986],
        [36.9634700050523, 127.871136155145],
        [36.965229655563014, 127.87176594033251],
        [36.9644304757065, 127.8713896429],
        [36.963953869127444, 127.87125957090191],
        [36.9652304379531, 127.870922650771],
        [36.96410204587237, 127.87071329197747],
        [36.9652298236221, 127.871497568971],
        [36.9634609869793, 127.871137175269],
        [36.9635657953382, 127.871343855813],
        [36.9632143099913, 127.87123093160251],
        [36.96385447257941, 127.87129773903422],
      ],
      markers: [],
      infowindow: null,
      isOpen: true,
      search: {
        keyword: null,
        pgn: null,
        results: [{ id: 0, place_name: "여긴어디" }],
      },
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        // 최초 위치
        center: new kakao.maps.LatLng(36.967257621809, 127.87179754134),
        level: 5,
      };
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    zoomIn() {
      let level = this.map.getLevel();
      this.map.setLevel(level - 1);
    },
    zoomOut() {
      let level = this.map.getLevel();
      this.map.setLevel(level + 1);
    },
    currentPos() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
          const latitude = position.coords.latitude;
          const longitude = position.coords.longitude;
          const latlong = new kakao.maps.LatLng(latitude, longitude);
          this.map.panTo(latlong);
          this.map.setLevel(2);
        });
      } else {
        alert("현재 위치를 불러오지 못했습니다.");
      }
    },
    toggleFold() {
      this.isOpen = !this.isOpen;
      console.log(this.isOpen);
    },
    searchPlace(e) {
      const keyword = e.target.value.trim();
      // 빈칸이면 반환 없음
      if (keyword.length === 0) {
        return;
      }
      else {
        this.$router.replace("/slide2");
      }
      // get__place(this.map.getLevel(), keyword);

      // ps는 data, status, pgn의 정보를 받아옴
      // ps.keywordSearch(keyword, (data, status, pgn) => {
      //   this.search.keyword = keyword;
      //   this.search.pgn = pgn;
      //   this.search.results = data;
      // })
    },

    searchPlaceNow() {
      let latlng = this.map.getCenter();
      get__place__name(this.map.getLevel(), latlng.getLat(), latlng.getLng());
    },
    // [위도, 경도] 로 이루어진 배열들의 모음
    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        // // 지도 범위 재설정
        // const bounds = positions.reduce(
        //   (bounds, latlng) => bounds.extend(latlng),
        //   new kakao.maps.LatLngBounds()
        // );

        // this.map.setBounds(bounds);
      }
    },

    // Click Marker로 변경, marker를 클릭 시 인포윈도우를 띄움
    displayInfoWindow() {
      if (this.infowindow && this.infowindow.getMap()) {
        //이미 생성한 인포윈도우가 있기 때문에 지도 중심좌표를 인포윈도우 좌표로 이동시킨다.
        this.map.setCenter(this.infowindow.getPosition());
        return;
      }

      let iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(33.450701, 126.570667), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

      this.infowindow = new kakao.maps.InfoWindow({
        map: this.map, // 인포윈도우가 표시될 지도
        position: iwPosition,
        content: iwContent,
        removable: iwRemoveable,
      });

      this.map.setCenter(iwPosition);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 100vw;
  height: 100vh;
}

.button-group {
  position: absolute;
  top: 30px;
}

.controll_btn {
  padding: 9px;
  min-width: fit-content;
  background: #b2dfdb;
  height: 65px;
  width: 65px;
  border-radius: 15px;
}
.controll_btn:hover {
  color: rgb(255, 255, 255);
  background: #00635b;
}

.zoom-button {
  position: fixed;
  display: flex;
  flex-direction: column;
  gap: 5px;
  bottom: 20px;
  right: 20px;
  z-index: 2;
}

.searchPlaceNow {
  position: absolute;
  height: 55px;
  padding: 0 18px;
  border-radius: 23px;
  background: #b2dfdb;
  box-shadow: 0 4px 10px 0 rgb(0 0 0 / 20%);
  color: rgb(66, 66, 66);
  white-space: nowrap;
  font-size: x-large;
  bottom: 20px;
  padding-top: 10px;
  left: 50%;
  z-index: 3;
}
.searchPlaceNow:hover {
  color: rgb(255, 255, 255);
  background: #00635b;
}
/**   =============== Side Bar =============== */
.sidebar {
  position: relative;
  height: 100vh;
  display: flex;
}

.userInfo {
  display: flex;
  flex-direction: column;
  width: 100px;
  align-items: center;
  justify-content: center;
  padding-bottom: 0;
  z-index: 3;
  background-color: #b2dfdb;
  color: #b2dfdb;
  border-right: 2px rgb(6, 181, 181) solid;
}
.profile {
  display: flex;
  flex-direction: column;
}
.name {
  padding-bottom: 10px;
}
.infoOption {
  display: flex;
  flex-direction: column;
  justify-content: center;
  border-top: 2px solid rgb(75, 169, 169);
  background-color: #b2dfdb;
  padding-top: 50px;
  margin: 0;
  min-width: 96px;
  align-items: center;
}

.infoOption:hover {
  color: rgb(255, 255, 255);
  background-color: #00635b;
}

.place_list {
  display: grid;
  flex-direction: column;
}

/** side bar fold button */
.fold_button {
  position: absolute;
  display: flex;
  align-items: center;
  background-color: #b2dfdb;
  top: 50%;
  left: 100%;
  box-shadow: 5px 0px rgb(255, 255, 255);
  transform: translateY(-50%);
  width: 22px;
  height: 6rem;
  z-index: 2;
}
.fold_button:hover {
  opacity: 0.8;
  background: #00635b;
}

/* sidebar show, hide class */
.showSidebar {
  position: relative;
  width: 500px;
  display: flex;
  flex-direction: column;
  z-index: 2;
  -webkit-animation: showSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation: showSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}
.hideSidebar {
  position: relative;
  width: fit-content;
  display: flex;
  flex-direction: column;
  z-index: 2;
  -webkit-animation: hideSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation: hideSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}

/* sidebar show, hide Animation */
@-webkit-keyframes hideSidebar {
  0% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(-100%);
    transform: translateX(-100%);
  }
}
@keyframes hideSidebar {
  0% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(-100%);
    transform: translateX(-100%);
  }
}
@-webkit-keyframes showSidebar {
  0% {
    -webkit-transform: translateX(-100%);
    transform: translateX(-100%);
  }
  100% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
  }
}
@keyframes showSidebar {
  0% {
    -webkit-transform: translateX(-100%);
    transform: translateX(-100%);
  }
  100% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
  }
}
</style>
