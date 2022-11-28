<template>
  <div>
    <!-- Modal -->
    <ModalView v-if="isModalViewed" @close-modal="isModalViewed = false">
      <Content />
    </ModalView>

    <div id="map">
      <!-- Side Bar -->
      <v-card class="sidebar">
        <!-- 로그인한 유저 정보 -->
        <v-list class="userInfo">
          <v-list-item class="profile">
            <v-img
              max-
              width="80px"
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
          <v-toolbar dense extended extension-height="8" height="78px">
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
          <v-virtual-scroll :items="items" item-height="84">
            <template v-slot:default="{ item }">
              <v-list-item :key="item">
                <v-list-item-action>
                  <v-btn fab depressed color="primary">
                    <strong>{{ item }}</strong>
                  </v-btn>
                </v-list-item-action>

                <v-list-item-content @click="ClickPlace">
                  <v-list-item-title>
                    <strong>{{ placename[item] }}</strong>
                  </v-list-item-title>
                </v-list-item-content>

                <v-list-item-action>
                  <v-icon large> mdi-open-in-new </v-icon>
                </v-list-item-action>
              </v-list-item>
              <v-divider color="teal"></v-divider>
            </template>
          </v-virtual-scroll>
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
import Content from "../components/Content";
import ModalView from "../components/ModalView";
// import get__place from "../API/GET/get";
import get__place__name from "../API/GET/get";

export default {
  components: {
    Content,
    ModalView,
  },
  data() {
    return {
      placeNameProp: "",
      isModalViewed: false,
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
        [37.5124709837621, 127.034448304491],
        [37.5145374347634, 127.029458772737],
        [37.51607668051205, 127.0405083407439],
        [37.5160878327651, 127.039503895459],
        [37.515804825807, 127.039777480852],
        [37.5184332106763, 127.030107335874],
        [37.5137410270759, 127.041235508952],
        [37.51534824556843, 127.02982783908611],
        [37.510094191886, 127.039984825259],
        [37.5203166598331, 127.035338774027],
        [37.5109939056625, 127.032438859511],
        [37.5154880272396, 127.032752996488],
        [37.5181106885105, 127.036378409568],
        [37.51681990831254, 127.03810165545936],
        [37.5183363984135, 127.028093809321],
        [37.5171664315327, 127.036396049667],
        [37.51613789121324, 127.04067578249368],
        [37.50986785826047, 127.03779952558008],
        [37.5116883705501, 127.036257660784],
        [37.5138453495258, 127.041787545596],
        [37.51750792479384, 127.03917208292052],
        [37.5162295938164, 127.035721434633],
        [37.51651184190703, 127.0378628271788],
        [37.521617677973204, 127.03543893519856],
        [37.52186058560857, 127.03662909986537],
        [37.510603796848, 127.045938976373],
        [37.515803126376866, 127.04208160106053],
        [37.507238568097, 127.032256273604],
        [37.5173646606217, 127.036368998147],
        [37.5161357904841, 127.036047158128],
        [37.519029563585256, 127.04223838500221],
        [37.5168419652755, 127.036735237162],
        [37.5172951984351, 127.039441187112],
        [37.5174836597289, 127.036151873189],
        [37.52114818515884, 127.03854050539661],
        [37.514849856696365, 127.03670145820617],
        [37.5167706707282, 127.034115460694],
        [37.5189524291083, 127.029148302031],
        [37.520450854963826, 127.03551983007482],
        [37.52114936759734, 127.03472831049967],
        [37.51693197944849, 127.03701128228153],
        [37.5151015236742, 127.035766141908],
        [37.5201970504659, 127.037533247377],
        [37.5152792229316, 127.04324523621],
        [37.5165417172405, 127.040160199231],
      ],
      markers: [],
      placename: [
        `진대감 논현본점`,
        `홍명`,
        `스시도우`,
        `공리 강남구청역점`,
        `진전복삼계탕`,
        `우정양곱창`,
        `남도음식토말 본점`,
        `로얄라운지`,
        `아카라`,
        `영동장어`,
        `세종한우 2호점`,
        `더수제비 논현점`,
        `해몽`,
        `한교방서울면옥`,
        `유정식당`,
        `맛짱조개`,
        `정가네손칼국수`,
        `가나돈까스의집`,
        `크래버대게나라 강남점`,
        `카메스시`,
        `노란상소갈비 강남구청점`,
        `홈수끼 학동점`,
        `팔당닭발&오징어 강남본점`,
        `마켓오 압구정점`,
        `스시코우지`,
        `수담한정식`,
        `봉밀가`,
        `일일향 2호점`,
        `136길 육미`,
        `진미평양냉면`,
        `무오키`,
        `땅코참숯구이 논현직영점`,
        `게방식당`,
        `대삼식당`,
        `대가방 본점`,
        `슈퍼집 논현점`,
        `가람국시 논현동점`,
        `평양면옥`,
        `한성칼국수`,
        `한우리 본점`,
        `고향집`,
        `단스시 논현본점`,
        `돌곰네`,
        `젠제로`,
        `창우수산 활새우직판장 강남구청점`,
      ],
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
  computed: {
    items() {
      return Array.from({ length: this.length }, (k, v) => v + 1);
    },
    length() {
      return 44;
    },
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
      this.displayMarker(this.markerPositions3);
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
        const iwContent = `<div >   <div class="body" data-id="body" style="min-height: 140px; min-width: 140px;
    padding: 30px;">
		<div class="head_tooltip">
			<strong class="placename" style="font-size: 30px; color: teal">유정 식당</strong>
			<a href="#none" target="_blank" data-id="detail" class="detail" style="padding-left:10px">상세보기<span class="img_tooltip coach_detail"></span></a>
		</div>
		<div class="metadata">
		</div>
		<div class="content">
			<a href="#none" data-id="placeimg" class="thumb_place">
				<span class="frame_g"></span>
			</a>
			<div class="content_place">
				<p data-id="address" class="address" title="서울 강남구 도산대로28길 14">서울 강남구 도산대로28길 14</p>
				<p data-id="addInfoAddr" class="addInfoAddr"><span class="zipcode">(우) 06040</span>(지번) 서울 강남구 논현동 8-8</p>
				<p data-id="contact" class="contact">
					<span data-id="phone" class="phone">02-511-4592</span>
				</p>

			</div>
		</div>
        <div data-id="addition" class="addition HIDDEN"></div>
        <div class="toolbar" data-id="toolbar"><div>
	<div class="InfoWindowToolbar">

    </div>

</div></div>

        <!--
        <a data-id="intercityBtn" href="#" class="intercityBtn HIDDEN">실시간예매</a>
        -->
	</div>  </div>`;
        // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

        // 인포윈도우를 생성합니다
        const infowindow = new kakao.maps.InfoWindow({
          content: iwContent,
          removable: true,
        });

        // 마커에 클릭이벤트를 등록합니다
        this.markers.forEach((marker) =>
          marker.addListener("click", () => {
            infowindow.open(this.map, marker);
          })
        );
        // 지도 범위 재설정
        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
    ClickPlace() {
      this.isModalViewed = true;
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
