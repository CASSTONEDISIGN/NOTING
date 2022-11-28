const rjfmrl = () => {
  const str = [
    {
      roadAddressName: "서울 강남구 학동로38길 38",
      x: 127.034448304491,
      y: 37.5124709837621,
      addressName: "서울 강남구 논현동 217-47",
      id: 10082619,
      placeName: "진대감 논현본점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 19",
      x: 127.87092962031538,
      y: 36.96475796179156,
      addressName: "충북 충주시 대소원면 검단리 350-52",
      id: 1008403419,
      placeName: "가마치통닭 교통대점",
    },
    {
      roadAddressName: "충북 충주시 봉방9길 14",
      x: 127.916674227826,
      y: 36.9742353673228,
      addressName: "충북 충주시 봉방동 203-2",
      id: 10241465,
      placeName: "대림불고기",
    },
    {
      roadAddressName: "서울 강남구 논현로131길 10",
      x: 127.029458772737,
      y: 37.5145374347634,
      addressName: "서울 강남구 논현동 37-9",
      id: 10972091,
      placeName: "홍명",
    },
    {
      roadAddressName: "서울 강남구 선릉로129길 13",
      x: 127.0405083407439,
      y: 37.51607668051205,
      addressName: "서울 강남구 논현동 242-9",
      id: 1099397266,
      placeName: "스시도우",
    },
    {
      roadAddressName: "서울 강남구 선릉로129길 24",
      x: 127.039503895459,
      y: 37.5160878327651,
      addressName: "서울 강남구 논현동 240-14",
      id: 11026324,
      placeName: "공리 강남구청역점",
    },
    {
      roadAddressName: "서울 강남구 선릉로129길 21",
      x: 127.039777480852,
      y: 37.515804825807,
      addressName: "서울 강남구 논현동 243-5",
      id: 1117702712,
      placeName: "진전복삼계탕",
    },
    {
      ressName: "서울 강남구 도산대로30길 23",
      x: 127.030107335874,
      y: 37.5184332106763,
      addressName: "서울 강남구 논현동 67-11",
      id: 1120567503,
      placeName: "우정양곱창",
    },
    {
      roadAddressName: "충북 충주시 능바우길 35",
      x: 127.90980107923559,
      y: 36.986385785268475,
      addressName: "충북 충주시 칠금동 364-13",
      id: 11470081,
      placeName: "탄금대왕갈비탕",
    },
    {
      roadAddressName: "서울 강남구 선릉로121길 13",
      x: 127.041235508952,
      y: 37.5137410270759,
      addressName: "서울 강남구 논현동 254-23",
      id: 11594198,
      placeName: "남도음식토말 본점",
    },
    {
      roadAddressName: "서울 강남구 논현로 709",
      x: 127.02982783908611,
      y: 37.51534824556843,
      addressName: "서울 강남구 논현동 36-8",
      id: 12006731,
      placeName: "로얄라운지",
    },
    {
      roadAddressName: "서울 강남구 봉은사로43길 14",
      x: 127.039984825259,
      y: 37.510094191886,
      addressName: "서울 강남구 논현동 272-31",
      id: 1207564995,
      placeName: "아카라",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 20",
      x: 127.871427379772,
      y: 36.9645887850697,
      addressName: "충북 충주시 대소원면 검단리 350-58",
      id: 1217955938,
      placeName: "춘천호반닭갈비&막국수 교통대점",
    },
    {
      roadAddressName: "충북 충주시 중원대로 3824",
      x: 127.88205538953929,
      y: 36.962336953307954,
      addressName: "충북 충주시 용두동 168-2",
      id: 12317079,
      placeName: "관현각 본점",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙로 30",
      x: 127.918570861157,
      y: 36.9817895563964,
      addressName: "충북 충주시 칠금동 1015",
      id: 12363235,
      placeName: "파리바게뜨 충주칠금점",
    },
    {
      roadAddressName: "충북 충주시 계명대로 26",
      x: 127.91715277479658,
      y: 36.982106878950546,
      addressName: "충북 충주시 칠금동 864",
      id: 12476740,
      placeName: "참치본가",
    },
    {
      roadAddressName: "서울 강남구 언주로148길 8",
      x: 127.035338774027,
      y: 37.5203166598331,
      addressName: "서울 강남구 논현동 98-8",
      id: 1257441291,
      placeName: "영동장어",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 8",
      x: 127.871101030708,
      y: 36.9634423299284,
      addressName: "충북 충주시 대소원면 만정리 194-6",
      id: 1285073437,
      placeName: "부어치킨 한국교통대점",
    },
    {
      roadAddressName: "충북 충주시 계명대로 32",
      x: 127.917801848978,
      y: 36.982098258226,
      addressName: "충북 충주시 칠금동 868",
      id: 1285081891,
      placeName: "태권치킨 칠금점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 중원대로 3930",
      x: 127.87026370742193,
      y: 36.96317635031259,
      addressName: "충북 충주시 대소원면 만정리 182-6",
      id: 13024845,
      placeName: "파리바게뜨 서충주농협점",
    },
    {
      roadAddressName: "서울 강남구 논현로 642",
      x: 127.032438859511,
      y: 37.5109939056625,
      addressName: "서울 강남구 논현동 216-10",
      id: 13102233,
      placeName: "세종한우 2호점",
    },
    {
      roadAddressName: "충북 충주시 탄금대로 221",
      x: 127.907209336629,
      y: 36.9838844742987,
      addressName: "충북 충주시 칠금동 315-1",
      id: 1325858265,
      placeName: "함경옥사과냉면만두 충주본점",
    },
    {
      roadAddressName: "서울 강남구 논현로132길 29",
      x: 127.032752996488,
      y: 37.5154880272396,
      addressName: "서울 강남구 논현동 85-1",
      id: 13291590,
      placeName: "더수제비 논현점",
    },
    {
      roadAddressName: "서울 강남구 학동로41길 32",
      x: 127.036378409568,
      y: 37.5181106885105,
      addressName: "서울 강남구 논현동 107-11",
      id: 13294737,
      placeName: "해몽",
    },
    {
      roadAddressName: "충북 충주시 대소원면 모단길 20-2",
      x: 127.874724028267,
      y: 36.9637896333657,
      addressName: "충북 충주시 대소원면 검단리 350",
      id: 1343328222,
      placeName: "예가돈까스",
    },
    {
      roadAddressName: "서울 강남구 학동로45길 8",
      x: 127.03810165545936,
      y: 37.51681990831254,
      addressName: "서울 강남구 논현동 117-8",
      id: 1428563543,
      placeName: "한교방서울면옥",
    },
    {
      roadAddressName: "충북 충주시 대소원면 용두제방길 4",
      x: 127.871852375899,
      y: 36.9652272187733,
      addressName: "충북 충주시 대소원면 검단리 78-7",
      id: 14512849,
      placeName: "오돈콩",
    },
    {
      roadAddressName: "충북 충주시 대가미7길 7",
      x: 127.923067174368,
      y: 36.9802409106871,
      addressName: "충북 충주시 칠금동 1119",
      id: 1467665831,
      placeName: "스마일만두",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 23",
      x: 127.870916271018,
      y: 36.9650646899668,
      addressName: "충북 충주시 대소원면 검단리 350-116",
      id: 15670775,
      placeName: "대학로 친구분식",
    },
    {
      roadAddressName: "충북 충주시 칠금12길 45",
      x: 127.919138565329,
      y: 36.9867805970208,
      addressName: "충북 충주시 칠금동 614",
      id: 15745350,
      placeName: "달마 설렁탕&숯불갈비 칠금점",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙3길 13",
      x: 127.919796828985,
      y: 36.9810015539826,
      addressName: "충북 충주시 칠금동 979",
      id: 1589951886,
      placeName: "착한감자탕해장국 충주점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 12",
      x: 127.871245077327,
      y: 36.963962986068,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 15969924,
      placeName: "토프랜드 충주대점",
    },
    {
      roadAddressName: "서울 강남구 도산대로28길 14",
      x: 127.028093809321,
      y: 37.5183363984135,
      addressName: "서울 강남구 논현동 8-8",
      id: 16037952,
      placeName: "유정식당",
    },
    {
      roadAddressName: "서울 강남구 언주로136길 10",
      x: 127.036396049667,
      y: 37.5171664315327,
      addressName: "서울 강남구 논현동 114-14",
      id: 16063439,
      placeName: "맛짱조개",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 20",
      x: 127.871337391682,
      y: 36.9645750285612,
      addressName: "충북 충주시 대소원면 검단리 350-58",
      id: 16123571,
      placeName: "또래오래 한국교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 12",
      x: 127.871344252354,
      y: 36.963994696407,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 16149089,
      placeName: "깐치호 충주대점",
    },
    {
      roadAddressName: "서울 강남구 선릉로129길 11",
      x: 127.04067578249368,
      y: 37.51613789121324,
      addressName: "서울 강남구 논현동 242-18",
      id: 16557397,
      placeName: "정가네손칼국수",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 7",
      x: 127.870664792256,
      y: 36.9634914836494,
      addressName: "충북 충주시 대소원면 만정리 194-5",
      id: 16832292,
      placeName: "피자콜 충주대점",
    },
    {
      roadAddressName: "서울 강남구 언주로 608",
      x: 127.03779952558008,
      y: 37.50986785826047,
      addressName: "서울 강남구 논현동 275-3",
      id: 16875542,
      placeName: "가나돈까스의집",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 12",
      x: 127.87119823568,
      y: 36.9637939307276,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 17164947,
      placeName: "윤박사탕수육",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 12",
      x: 127.87125167031604,
      y: 36.96395032286666,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 1733383163,
      placeName: "연애포차",
    },
    {
      roadAddressName: "충북 충주시 봉계1길 31",
      x: 127.914134306912,
      y: 36.9797117341364,
      addressName: "충북 충주시 봉방동 981-1",
      id: 1767954731,
      placeName: "도담도담식빵 충주점",
    },
    {
      roadAddressName: "서울 강남구 언주로 620",
      x: 127.036257660784,
      y: 37.5116883705501,
      addressName: "서울 강남구 논현동 261",
      id: 1777540958,
      placeName: "크래버대게나라 강남점",
    },
    {
      roadAddressName: "서울 강남구 선릉로121길 7",
      x: 127.041787545596,
      y: 37.5138453495258,
      addressName: "서울 강남구 논현동 254-26",
      id: 1811533507,
      placeName: "카메스시",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 9",
      x: 127.870686038623,
      y: 36.9635823347936,
      addressName: "충북 충주시 대소원면 만정리 194",
      id: 1818410886,
      placeName: "아빠포차",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 19",
      x: 127.870913565497,
      y: 36.9647286149388,
      addressName: "충북 충주시 대소원면 검단리 350-52",
      id: 1818652437,
      placeName: "두꺼비네",
    },
    {
      roadAddressName: "충북 충주시 계명대로 32",
      x: 127.917801848978,
      y: 36.982098258226,
      addressName: "충북 충주시 칠금동 868",
      id: 1820613774,
      placeName: "큰맘할매순대국 충주점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 23",
      x: 127.8709093905,
      y: 36.9650521256159,
      addressName: "충북 충주시 대소원면 검단리 350-116",
      id: 1820857130,
      placeName: "빨간돼지 교통대점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 13",
      x: 127.87077041062898,
      y: 36.96408901216124,
      addressName: "충북 충주시 대소원면 만정리 193",
      id: 1848740651,
      placeName: "신신마라탕 충주교통대점",
    },
    {
      roadAddressName: "충북 충주시 우륵로 14",
      x: 127.918915062549,
      y: 36.9805254183862,
      addressName: "충북 충주시 칠금동 1025",
      id: 1874128935,
      placeName: "짬뽕가게",
    },
    {
      roadAddressName: "충북 충주시 봉계13길 10",
      x: 127.915930081397,
      y: 36.9803610676601,
      addressName: "충북 충주시 봉방동 76-3",
      id: 19020263,
      placeName: "공주얼큰이 칠금점",
    },
    {
      roadAddressName: "충북 충주시 봉현로 80",
      x: 127.915921436498,
      y: 36.9755170700763,
      addressName: "충북 충주시 봉방동 209",
      id: 19245824,
      placeName: "봉우맛집",
    },
    {
      roadAddressName: "충북 충주시 봉계1길 60",
      x: 127.915993881024,
      y: 36.9815607782176,
      addressName: "충북 충주시 칠금동 856",
      id: 1955484624,
      placeName: "본죽&비빔밥cafe 충주터미널점",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙1길 21",
      x: 127.919097205662,
      y: 36.9814755202412,
      addressName: "충북 충주시 칠금동 1006",
      id: 19637316,
      placeName: "옛가마솥보리밥부페",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙로 30",
      x: 127.918502035114,
      y: 36.98157653941171,
      addressName: "충북 충주시 칠금동 1015",
      id: 1970351831,
      placeName: "준경양카츠",
    },
    {
      roadAddressName: "충북 충주시 봉계1길 34",
      x: 127.91453426972853,
      y: 36.97972307045542,
      addressName: "충북 충주시 봉방동 88-2",
      id: 19714369,
      placeName: "충주수산",
    },
    {
      roadAddressName: "서울 강남구 선릉로131길 22",
      x: 127.03917208292052,
      y: 37.51750792479384,
      addressName: "서울 강남구 논현동 112-7",
      id: 1997921938,
      placeName: "노란상소갈비 강남구청점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 5",
      x: 127.870627467931,
      y: 36.9633692133337,
      addressName: "충북 충주시 대소원면 만정리 734-19",
      id: 2013119055,
      placeName: "타베",
    },
    {
      roadAddressName: "충북 충주시 봉계1길 32",
      x: 127.9142901731485,
      y: 36.97940958193766,
      addressName: "충북 충주시 봉방동 89-1",
      id: 2034338993,
      placeName: "와플칸 충주터미널점",
    },
    {
      ressName: "충북 충주시 계명대로 33-1",
      x: 127.918174380728,
      y: 36.9826297017456,
      addressName: "충북 충주시 칠금동 845",
      id: 2054343544,
      placeName: "소이반",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 12",
      x: 127.87125620253748,
      y: 36.96395389384447,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 20627655,
      placeName: "새마을연탄구이",
    },
    {
      roadAddressName: "서울 강남구 언주로 708",
      x: 127.035721434633,
      y: 37.5162295938164,
      addressName: "서울 강남구 논현동 115-1",
      id: 2079150406,
      placeName: "홈수끼 학동점",
    },
    {
      roadAddressName: "서울 강남구 학동로45길 3",
      x: 127.0378628271788,
      y: 37.51651184190703,
      addressName: "서울 강남구 논현동 116-5",
      id: 20943718,
      placeName: "팔당닭발&오징어 강남본점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 18",
      x: 127.871385110643,
      y: 36.9644269047346,
      addressName: "충북 충주시 대소원면 검단리 350-83",
      id: 21063191,
      placeName: "봉구스밥버거 교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 중원대로 4020",
      x: 127.86062606373252,
      y: 36.96486850580339,
      addressName: "충북 충주시 대소원면 만정리 282-1",
      id: 21246305,
      placeName: "만선식당",
    },
    {
      roadAddressName: "충북 충주시 중원대로 3845",
      x: 127.879545654345,
      y: 36.9620311901127,
      addressName: "충북 충주시 용두동 403-4",
      id: 21246464,
      placeName: "묵고을",
    },
    {
      roadAddressName: "서울 강남구 도산대로 310",
      x: 127.03543893519856,
      y: 37.521617677973204,
      addressName: "서울 강남구 논현동 91-6",
      id: 21311108,
      placeName: "마켓오 압구정점",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙로 27",
      x: 127.91803385565505,
      y: 36.982151428474396,
      addressName: "충북 충주시 칠금동 869",
      id: 21347097,
      placeName: "김밥생각 1호점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 11",
      x: 127.870687148229,
      y: 36.9638769728943,
      addressName: "충북 충주시 대소원면 만정리 193-13",
      id: 21349185,
      placeName: "공룡 뒷고기앤공룡일식",
    },
    {
      roadAddressName: "충북 충주시 대소원면 용두제방길 4",
      x: 127.871764848347,
      y: 36.965232366756375,
      addressName: "충북 충주시 대소원면 검단리 78-7",
      id: 21359615,
      placeName: "맘스터치 충주교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 23",
      x: 127.87094983198573,
      y: 36.96505363108254,
      addressName: "충북 충주시 대소원면 검단리 350-116",
      id: 219416333,
      placeName: "동대문엽기떡볶이 충주교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 28",
      x: 127.87156483466491,
      y: 36.96522031928057,
      addressName: "충북 충주시 대소원면 검단리 78-17",
      id: 219866740,
      placeName: "이삭토스트 충주한국교통대점",
    },
    {
      roadAddressName: "서울 강남구 도산대로 318",
      x: 127.03662909986537,
      y: 37.52186058560857,
      addressName: "서울 강남구 논현동 92",
      id: 23829251,
      placeName: "스시코우지",
    },
    {
      dressName: "충북 충주시 금제로 28",
      x: 127.923185368064,
      y: 36.9896505794567,
      addressName: "충북 충주시 금릉동 682",
      id: 23840178,
      placeName: "숲속장수촌 본점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 11",
      x: 127.870695884271,
      y: 36.9638552834197,
      addressName: "충북 충주시 대소원면 만정리 193-13",
      id: 24201538,
      placeName: "생각나는감자탕",
    },
    {
      roadAddressName: "충북 충주시 번영대로 20",
      x: 127.919613785129,
      y: 36.9870688572649,
      addressName: "충북 충주시 칠금동 568",
      id: 24258862,
      placeName: "바르미 샤브샤브n칼국수 충주점",
    },
    {
      roadAddressName: "서울 강남구 봉은사로 418",
      x: 127.045938976373,
      y: 37.510603796848,
      addressName: "서울 강남구 삼성동 113",
      id: 25744174,
      placeName: "수담한정식",
    },
    {
      roadAddressName: "충북 충주시 계명대로 24",
      x: 127.91703643273753,
      y: 36.982145621973544,
      addressName: "충북 충주시 칠금동 863",
      id: 25757955,
      placeName: "24시전주명가콩나물국밥",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 25",
      x: 127.870908807595,
      y: 36.9651981013861,
      addressName: "충북 충주시 대소원면 검단리 350-115",
      id: 26015172,
      placeName: "짱돌",
    },
    {
      roadAddressName: "충북 충주시 칠금15길 12",
      x: 127.923127995982,
      y: 36.9856467519926,
      addressName: "충북 충주시 칠금동 666",
      id: 26313068,
      placeName: "우리바다회",
    },
    {
      roadAddressName: "충북 충주시 봉현로 100-1",
      x: 127.917139900787,
      y: 36.9771043305394,
      addressName: "충북 충주시 봉방동 268-6",
      id: 26556044,
      placeName: "고운밥상",
    },
    {
      roadAddressName: "서울 강남구 선릉로 664",
      x: 127.04208160106053,
      y: 37.515803126376866,
      addressName: "서울 강남구 삼성동 8-1",
      id: 26794399,
      placeName: "봉밀가",
    },
    {
      roadAddressName: "서울 강남구 봉은사로 167",
      x: 127.032256273604,
      y: 37.507238568097,
      addressName: "서울 강남구 논현동 206-5",
      id: 26858784,
      placeName: "일일향 2호점",
    },
    {
      roadAddressName: "충북 충주시 능바우길 1",
      x: 127.908772495109,
      y: 36.9836706818799,
      addressName: "충북 충주시 칠금동 329-19",
      id: 26880921,
      placeName: "본가석갈비",
    },
    {
      roadAddressName: "충북 충주시 능바우길 15",
      x: 127.90908619178629,
      y: 36.98473692902388,
      addressName: "충북 충주시 칠금동 329-6",
      id: 27362568,
      placeName: "이씨식당",
    },
    {
      roadAddressName: "서울 강남구 언주로136길 9",
      x: 127.036368998147,
      y: 37.5173646606217,
      addressName: "서울 강남구 논현동 107-34",
      id: 27440495,
      placeName: "136길 육미",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 21",
      x: 127.87093770475671,
      y: 36.9648762114907,
      addressName: "충북 충주시 대소원면 검단리 350-117",
      id: 27527591,
      placeName: "신전떡볶이 교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 21",
      x: 127.870878329683,
      y: 36.9648883607757,
      addressName: "충북 충주시 대소원면 검단리 350-117",
      id: 27545514,
      placeName: "한솥도시락 충주교통대점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 19-3",
      x: 127.87071940163963,
      y: 36.96453991561552,
      addressName: "충북 충주시 대소원면 만정리 192-8",
      id: 27561748,
      placeName: "달주",
    },
    {
      roadAddressName: "서울 강남구 학동로 305-3",
      x: 127.036047158128,
      y: 37.5161357904841,
      addressName: "서울 강남구 논현동 115-10",
      id: 27584230,
      placeName: "진미평양냉면",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙1길 12-1",
      x: 127.919297885555,
      y: 36.9806053513216,
      addressName: "충북 충주시 칠금동 1042",
      id: 296851171,
      placeName: "칭따오양고기",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 17",
      x: 127.87087454060834,
      y: 36.96435856606099,
      addressName: "충북 충주시 대소원면 만정리 734-14",
      id: 299016044,
      placeName: "온정 한국교통대점",
    },
    {
      roadAddressName: "충북 충주시 봉계1길 29",
      x: 127.9139380246499,
      y: 36.97945193989986,
      addressName: "충북 충주시 봉방동 981",
      id: 303269212,
      placeName: "진우동돈까스",
    },
    {
      roadAddressName: "충북 충주시 봉계13길 30",
      x: 127.917992337443,
      y: 36.9792566660344,
      addressName: "충북 충주시 봉방동 85-1",
      id: 312323842,
      placeName: "플랩잭팬트리 충주점",
    },
    {
      roadAddressName: "서울 강남구 학동로55길 12-12",
      x: 127.04223838500221,
      y: 37.519029563585256,
      addressName: "서울 강남구 청담동 38-4",
      id: 312947795,
      placeName: "무오키",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 26",
      x: 127.871432719986,
      y: 36.9650572963569,
      addressName: "충북 충주시 대소원면 검단리 79-11",
      id: 327420870,
      placeName: "역전할머니맥주 충주교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 8",
      x: 127.871136155145,
      y: 36.9634700050523,
      addressName: "충북 충주시 대소원면 만정리 194-6",
      id: 359078050,
      placeName: "아빠부대찌개",
    },
    {
      roadAddressName: "충북 충주시 대소원면 용두제방길 4",
      x: 127.87176594033251,
      y: 36.965229655563014,
      addressName: "충북 충주시 대소원면 검단리 78-7",
      id: 360566500,
      placeName: "명랑핫도그 충주교통대점",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙3길 14",
      x: 127.92001205897583,
      y: 36.98096744824321,
      addressName: "충북 충주시 칠금동 978",
      id: 417779932,
      placeName: "자금성 본점",
    },
    {
      roadAddressName: "서울 강남구 언주로134길 13",
      x: 127.036735237162,
      y: 37.5168419652755,
      addressName: "서울 강남구 논현동 114-25",
      id: 419923613,
      placeName: "땅코참숯구이 논현직영점",
    },
    {
      roadAddressName: "서울 강남구 선릉로131길 17",
      x: 127.039441187112,
      y: 37.5172951984351,
      addressName: "서울 강남구 논현동 118-20",
      id: 499958291,
      placeName: "게방식당",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 18",
      x: 127.8713896429,
      y: 36.9644304757065,
      addressName: "충북 충주시 대소원면 검단리 350-83",
      id: 53157246,
      placeName: "사천마라탕 교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 12",
      x: 127.87125957090191,
      y: 36.963953869127444,
      addressName: "충북 충주시 대소원면 만정리 193-11",
      id: 546120082,
      placeName: "태권치킨 교통대점",
    },
    {
      roadAddressName: "충북 충주시 봉계13길 22",
      x: 127.917148281593,
      y: 36.9796740702935,
      addressName: "충북 충주시 봉방동 84-2",
      id: 558187859,
      placeName: "포유탐",
    },
    {
      roadAddressName: "충북 충주시 우륵로 24",
      x: 127.918904174375,
      y: 36.9814878272291,
      addressName: "충북 충주시 칠금동 1011",
      id: 567419632,
      placeName: "대한곱창 충주점",
    },
    {
      roadAddressName: "서울 강남구 학동로41길 23",
      x: 127.036151873189,
      y: 37.5174836597289,
      addressName: "서울 강남구 논현동 106-17",
      id: 634970976,
      placeName: "대삼식당",
    },
    {
      roadAddressName: "충북 충주시 계명대로 35",
      x: 127.9183428271097,
      y: 36.98262749770222,
      addressName: "충북 충주시 칠금동 846",
      id: 686561412,
      placeName: "맘스터치 충주칠금점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 25",
      x: 127.870922650771,
      y: 36.9652304379531,
      addressName: "충북 충주시 대소원면 검단리 350-115",
      id: 702883613,
      placeName: "슬기로운대학생활 교통대점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 13",
      x: 127.87071329197747,
      y: 36.96410204587237,
      addressName: "충북 충주시 대소원면 만정리 193",
      id: 707214330,
      placeName: "부리또인충주 교통대점",
    },
    {
      roadAddressName: "서울 강남구 선릉로145길 13",
      x: 127.03854050539661,
      y: 37.52114818515884,
      addressName: "서울 강남구 논현동 99-7",
      id: 7815078,
      placeName: "대가방 본점",
    },
    {
      ressName: "서울 강남구 언주로130길 14",
      x: 127.03670145820617,
      y: 37.514849856696365,
      addressName: "서울 강남구 논현동 246-1",
      id: 7850629,
      placeName: "슈퍼집 논현점",
    },
    {
      roadAddressName: "서울 강남구 언주로135길 13",
      x: 127.034115460694,
      y: 37.5167706707282,
      addressName: "서울 강남구 논현동 83-19",
      id: 8121093,
      placeName: "가람국시 논현동점",
    },
    {
      roadAddressName: "서울 강남구 논현로150길 6",
      x: 127.029148302031,
      y: 37.5189524291083,
      addressName: "서울 강남구 논현동 66-2",
      id: 8130016,
      placeName: "평양면옥",
    },
    {
      roadAddressName: "서울 강남구 언주로148길 14",
      x: 127.03551983007482,
      y: 37.520450854963826,
      addressName: "서울 강남구 논현동 98-12",
      id: 8140834,
      placeName: "한성칼국수",
    },
    {
      roadAddressName: "서울 강남구 도산대로 304",
      x: 127.03472831049967,
      y: 37.52114936759734,
      addressName: "서울 강남구 논현동 91-18",
      id: 8156521,
      placeName: "한우리 본점",
    },
    {
      roadAddressName: "서울 강남구 언주로134길 17",
      x: 127.03701128228153,
      y: 37.51693197944849,
      addressName: "서울 강남구 논현동 114-27",
      id: 8188651,
      placeName: "고향집",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 28",
      x: 127.871497568971,
      y: 36.9652298236221,
      addressName: "충북 충주시 대소원면 검단리 79-2",
      id: 8219988,
      placeName: "네네치킨 한국교통대점",
    },
    {
      roadAddressName: "충북 충주시 계명대로 19",
      x: 127.91659117425,
      y: 36.9826662651374,
      addressName: "충북 충주시 칠금동 836",
      id: 8271080,
      placeName: "뚜레쥬르 충주터미널점",
    },
    {
      roadAddressName: "서울 강남구 언주로 652",
      x: 127.035766141908,
      y: 37.5151015236742,
      addressName: "서울 강남구 논현동 238",
      id: 8306074,
      placeName: "단스시 논현본점",
    },
    {
      ressName: "충북 충주시 대소원면 대학로 8",
      x: 127.871137175269,
      y: 36.9634609869793,
      addressName: "충북 충주시 대소원면 만정리 194-6",
      id: 832032360,
      placeName: "배가네국수",
    },
    {
      roadAddressName: "충북 충주시 봉방천변길 48",
      x: 127.915427772652,
      y: 36.97555691988,
      addressName: "충북 충주시 봉방동 187-4",
      id: 8405475,
      placeName: "산골화로구이",
    },
    {
      roadAddressName: "충북 충주시 상방1길 34",
      x: 127.91202351719711,
      y: 36.97562637171872,
      addressName: "충북 충주시 봉방동 174",
      id: 8444356,
      placeName: "시골추어탕",
    },
    {
      roadAddressName: "충북 충주시 봉방9길 2",
      x: 127.915583129819,
      y: 36.9750259020509,
      addressName: "충북 충주시 봉방동 204",
      id: 8609904,
      placeName: "큰집막창 봉방점",
    },
    {
      roadAddressName: "충북 충주시 계명대로 25",
      x: 127.917093435042,
      y: 36.9825903017419,
      addressName: "충북 충주시 칠금동 839",
      id: 868992789,
      placeName: "역전우동0410 충주칠금점",
    },
    {
      roadAddressName: "충북 충주시 봉계4길 22",
      x: 127.916855798845,
      y: 36.9777624920725,
      addressName: "충북 충주시 봉방동 101-1",
      id: 882567798,
      placeName: "열라짬뽕",
    },
    {
      roadAddressName: "서울 강남구 언주로146길 18",
      x: 127.037533247377,
      y: 37.5201970504659,
      addressName: "서울 강남구 논현동 105",
      id: 8915439,
      placeName: "돌곰네",
    },
    {
      roadAddressName: "서울 강남구 선릉로126길 14",
      x: 127.04324523621,
      y: 37.5152792229316,
      addressName: "서울 강남구 삼성동 10-18",
      id: 900538186,
      placeName: "젠제로",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙3길 6",
      x: 127.9200132757,
      y: 36.9803222849118,
      addressName: "충북 충주시 칠금동 1067",
      id: 9198463,
      placeName: "신양자강 칠금점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 10-6",
      x: 127.871343855813,
      y: 36.9635657953382,
      addressName: "충북 충주시 대소원면 만정리 197",
      id: 923172738,
      placeName: "도란도락",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙3길 1",
      x: 127.919771162335,
      y: 36.9799889693061,
      addressName: "충북 충주시 칠금동 1064",
      id: 9298634,
      placeName: "우리집청국장",
    },
    {
      roadAddressName: "충북 충주시 신립로 79",
      x: 127.92168578975074,
      y: 36.986948265129584,
      addressName: "충북 충주시 칠금동 577",
      id: 9300898,
      placeName: "춘천메밀촌닭갈비",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 6",
      x: 127.87123093160251,
      y: 36.9632143099913,
      addressName: "충북 충주시 대소원면 만정리 196",
      id: 9350926,
      placeName: "일미닭갈비",
    },
    {
      roadAddressName: "충북 충주시 칠금중앙로 44",
      x: 127.919684868893,
      y: 36.981777326866,
      addressName: "충북 충주시 칠금동 985",
      id: 9488336,
      placeName: "칠금동 버섯매운탕샤브샤브칼국수 본점",
    },
    {
      roadAddressName: "서울 강남구 학동로 338",
      x: 127.040160199231,
      y: 37.5165417172405,
      addressName: "서울 강남구 논현동 241-1",
      id: 992715161,
      placeName: "창우수산 활새우직판장 강남구청점",
    },
    {
      roadAddressName: "충북 충주시 대소원면 대학로 12",
      x: 127.87129773903422,
      y: 36.96385447257941,
      addressName: "충북 충주시 대소원면 만정리 235-2",
      id: 997366413,
      placeName: "리밍",
    },
  ];
  const rjfmrlakd = /^서울/;
  const school = str.filter((x) => rjfmrlakd.test(x.addressName));
  let result = []
  console.log(school.length)
//   for(let i = 0; i < 45; i++){
//     result += "[" + Array(school[i].y, school[i].x) + "],"
//   }
  for(let i = 0; i < 45; i++){
    result += "`" + Array(school[i].placeName) + "`,"
  }
  console.log(result);
//   console.log(school)
};
rjfmrl();