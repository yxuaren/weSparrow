# WeSparrow Backend - Phase 1 Prototype

## Prerequisites
- Java 17
- Maven 3.9+
- PostgreSQL running locally (db `cardgame`, user `postgres`, password `postgres`)

Create DB:
```bash
createdb cardgame || psql -c 'CREATE DATABASE cardgame;'
```

## Run
```bash
mvn spring-boot:run
```

## API
Start a match:
```bash
curl -X POST http://localhost:8080/match/start
```

Play a card for 4 damage (example):
```bash
# Replace MATCH_ID from previous response
curl -X POST http://localhost:8080/match/action   -H "Content-Type: application/json"   -d '{"matchId": 1, "action": "PLAY_CARD", "value": 4}'
```

End turn:
```bash
curl -X POST http://localhost:8080/match/action   -H "Content-Type: application/json"   -d '{"matchId": 1, "action": "END_TURN"}'
```