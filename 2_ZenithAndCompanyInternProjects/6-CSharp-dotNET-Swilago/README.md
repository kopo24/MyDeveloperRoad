# 제니스&컴퍼니 정사원때 동기랑 만든 프로젝트 - 점심 룰렛 쉬라고(Swilago)
백엔드는 내가, 프론트는 동기가 만들었음.
프론트에서 실행한 룰렛 결과, 룰렛 판의 내용, 룰렛을 돌린 사람, 그 사람의 최종 접속일 자 등을 받아서 내부 로직대로 데이터를 정제하여 MSSQL에 저장.
사용자 접속 시, DB에 사용자 정보를 조회하여 신규인지, 기존 유저인지 확인하여 기본 룰렛판과 기존 유저의 마지막 룰렛 판을 화면에 띄움.

# Swilago
Before run this project, unpack node_modules where ./ClientApp/node_modules.zip.
And Run project must be IIS.
