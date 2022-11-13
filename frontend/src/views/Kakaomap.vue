<template>
  <div>
    <div id="map">

      <!-- Side Bar -->
      <v-card :class="isOpen ? 'showsideBar' : 'hideSidebar'">
        <v-toolbar dense floating>
          <v-text-field
            hide-details
            prepend-icon="mdi-magnify"
            single-line
          ></v-text-field>
        </v-toolbar>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="text-h6">
              Application
            </v-list-item-title>
            <v-list-item-title class="text-h6">
              Application
            </v-list-item-title>
            <v-list-item-title class="text-h6">
              Application
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <button class="fold_button" @click="toggleFold()">
          <v-icon>mdi-menu-left</v-icon>
        </button>
      </v-card>
      <!--  /Side Bar  -->

      <!-- Map Option Button -->
      <div class="zoom-button">
        <v-btn @click="currentPos">
          <v-icon>mdi-crosshairs-gps</v-icon>
        </v-btn>
        <v-btn @click="zoomIn">
          <v-icon>fa-plus</v-icon>
        </v-btn>
        <v-btn @click="zoomOut">
          <v-icon>fa-minus</v-icon>
        </v-btn>
      </div>
    </div>
    <!-- <div class="button-group">
        <button @click="displayMarker(markerPositions1)">marker set 1</button>
        <button @click="displayMarker(markerPositions2)">marker set 2</button>
        <button @click="displayMarker([])">marker set 3 (empty)</button>
        <button @click="displayInfoWindow">infowindow</button>
      </div> -->
  </div>
</template>

<script>
export default {
  name: "KakaoMap",
  data() {
    return {
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
      markers: [],
      infowindow: null,
      isOpen: true,
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
        center: new kakao.maps.LatLng(37.9698032, 127.8721668),
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
          this.map.setLevel(1);
        });
      } else {
        alert("현재 위치를 불러오지 못했습니다.");
      }
    },
    toggleFold() {
      this.isOpen = !this.isOpen;
      console.log(this.isOpen);
    },
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

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
    displayInfoWindow() {
      if (this.infowindow && this.infowindow.getMap()) {
        //이미 생성한 인포윈도우가 있기 때문에 지도 중심좌표를 인포윈도우 좌표로 이동시킨다.
        this.map.setCenter(this.infowindow.getPosition());
        return;
      }

      var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
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
  margin: 10px 0px;
}

v-btn {
  padding: 9px;
  min-width: fit-content;
  height: 32px;
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



/**   =============== Side Bar =============== */

/** side bar fold button */
.fold_button {
  position: absolute;
  display: flex;
  align-items: center;
  background-color: rgb(210, 210, 210);
  top: 50%;
  left: 100%;
  box-shadow: 5px 0px rgb(198, 198, 198);
  transform: translateY(-50%);
  width: 22px;
  height: 6rem;
  z-index: 2;
}
.fold_button:hover {
  opacity: 0.8;
}
.fold-button {
  transform: translateX(-100%);
  animation-timing-function: ease-in-out;
}

/* sidebar show, hide class */
.showsideBar {
  position: absolute;
  top: 0;
  display: flex;
  flex-direction: column;
  height: 100vh;
  z-index: 2;
  -webkit-animation: showSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation: showSidebar 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}
.hideSidebar {
  position: absolute;
  top: 0;
  display: flex;
  flex-direction: column;
  height: 100vh;
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
