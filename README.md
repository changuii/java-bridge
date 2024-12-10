## 기능 목록

### 입력

- [x]  자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
    - [x] 3 이상 20 이하의 수를 입력해야 한다.
    - [x] 숫자만 입력해야 한다.

```
3
```

- [x]  라운드마다 플레이어가 이동할 칸을 입력 받는다. U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
U
```

- [x]  게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
R
```

### 출력

- [ ]  게임 시작 문구

```
다리 건너기 게임을 시작합니다.
```

- [ ]  다리 길이 입력 문구

```
다리의 길이를 입력해주세요.
```

- [ ]  이동할 칸 입력 문구

```java
이동할 칸을 선택해주세요. (위: U, 아래: D)
```

- [ ]  게임 종료 문구

```
최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

- [ ]  사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
  - [ ]  이동할 수 있는 칸을 선택한 경우 O 표시
  - [ ]  이동할 수 없는 칸을 선택한 경우 X 표시
  - [ ]  선택하지 않은 칸은 공백 한 칸으로 표시
  - [ ]  다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
  - [ ]  다리 칸의 구분은 `|`(앞뒤 공백 포함) 문자열로 구분
  - [ ]  현재까지 건넌 다리를 모두 출력
- [ ]  예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```java
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```

### 실행 결과 예시

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R
이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2

```

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
Q
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1

```

---

### 기능

- [ ]  사용자는 위쪽, 혹은 아래쪽을 선택하여 다음 칸으로 이동한다.
  - [ ]  U : 위쪽 다리로 이동한다.
  - [ ]  D : 아래쪽 다리로 이동한다.
- [ ]  다리의 길이를 숫자로 입력받고 생성한다.
  - [ ]  0 : 아래 칸이 건널 수 있는 칸이 된다.
  - [ ]  1 : 위쪽 칸이 건널 수 있는 칸이 된다.
- [ ]  사용자가 다리를 건너는 것에 실패하거나, 모든 칸을 지나갈 때까지, 사용자가 이동할 칸을 입력받는다.
- [ ]  이동한 칸을 건널 수 있다면 O, 건널 수 없다면 X로 표기한다.
- [ ]  다리가 더이상 존재하지 않는다면 게임이 종료된다.
- [ ]  게임이 종료되면, 다음의 작업을 수행한다.
  - [ ]  최종 게임 결과 출력 (이동한 내역을 출력)
  - [ ]  게임의 성공 여부를 출력
  - [ ]  총 시도한 횟수를 출력
- [ ]  건널 수 없는 곳으로 이동하면 게임이 중단된다.
- [ ]  게임이 중단되면, 다음의 작업을 수행한다.
  - [ ]  게임 종료와 게임 재시도를 사용자에 입력에따라 진행된다.

### 실행 흐름

1. 사용자에게 게임 시작 문구 출력
2. 사용자에게 다리 길이 입력 문구 출력
3. 사용자에게 다리 길이를 입력
  - 3 ~ 20 사이의 길이만 입력할 수 있다.
  - 숫자만 입력할 수 있다.
4. 사용자에게 이동할 칸의 위치(상단, 하단) 입력 문구 출력
5. 사용자에게 이동할 칸의 위치(상단, 하단) 입력
  - U 혹은 D만 입력할 수 있다.
6. 사용자가 이동한 만큼 맵을 출력한다.
  - 사용자가 이동할 수 있는 칸을 선택한 경우 O 표시
  - 사용자가 이동할 수 없는 칸을 선택한 경우 X 표시
  - 사용자가 선택하지 않은 칸은 공백 한 칸으로 표시
  - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
  - 다리 칸의 구분은 `|`(앞뒤 공백 포함) 문자열로 구분
  - 현재까지 건넌 다리를 모두 출력
7. 사용자의 위치가 다리를 모두 지나갔다면 게임이 종료된다.
8. 사용자의 위치가 지나갈 수 없는 다리 위치라면, 게임이 중단되고 중단 메시지를 출력한다.
9. 게임이 중단되면 다음을 입력받는다.
  - R : 재시도, 게임이 재시도되지만, 다리의 형태는 유지한다.
  - Q : 종료, 게임이 종료된다.
10. 게임이 종료되면, 사용자에게 최종 게임 결과를 출력한다.

### 예외 상황

**다리 길이 입력**

- 사용자가 다리의 길이를 3 ~ 20 이외의 값을 입력한 경우
- 사용자가 다리의 길이로 문자를 입력한 경우

**다리의 다음 위치 입력**

- 사용자가 이동할 칸의 위치를 U D 이외의 값을 입력한 경우

**재시도 혹은 종료 선택 입력**

- 사용자가 게임이 중단된 경우에 입력한 값에 R, Q 이외의 값을 입력한 경우