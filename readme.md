# Workshop Kotlin & SpringBoot

## Endpoints

`GET /todos`

Response: 200 ok
```
[
    {
        "id": 1,
        "title": "Dummy ToDo Title",
        "description": "Dummy description",
        "user_id": "dummy_user_id",
        "created_at": "2020-02-09T08:33:54.735",
        "completed": false
    },
    // ...
]
```

`POST /todos`

Body:
```
{
	"title": "Dummy ToDo Title",
	"user_id": "dummy_user_id"
}
```

Response: 201 created
```
{
    "id": 1,
    "title": "Dummy ToDo Title",
    "description": null,
    "user_id": "dummy_user_id",
    "created_at": "2020-02-09T08:33:54.735",
    "completed": false
}
```

`GET /todos/<id>`

Response: 200 ok
```
{
    "id": 1,
    "title": "Dummy ToDo Title",
    "description": "Dummy description",
    "user_id": "dummy_user_id",
    "created_at": "2020-02-09T08:33:54.735",
    "completed": false
}
```

`PUT /todos/<id>`

Body:
```
{
    "id": 1,
    "title": "Dummy ToDo Title Update",
    "description": "Dummy description",
    "user_id": "dummy_user_id",
    "created_at": "2020-02-09T08:33:54.735",
    "completed": true
}
```

Response: 200 ok (or 204 - no content)
```
{
    "id": 1,
    "title": "Dummy ToDo Title Update",
    "description": "Dummy description",
    "user_id": "dummy_user_id",
    "created_at": "2020-02-09T08:33:54.735",
    "completed": true
}
```

`DELETE /todos/<id>`

Response: 204 ok, no content

`GET /stats?user_id=<user_id>`

Response: 200 ok

```
{
    "created": 3,
    "updated": 2,
    "deleted": 0
}
```