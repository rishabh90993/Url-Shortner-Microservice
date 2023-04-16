
# Url Shortner MicroService

A Simple Url Shortner MicroService that can be Plugged in to any System and can be used.
![Logo](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e2046a25e8f84ab7bd6e0ff50228e0a1~tplv-k3u1fbpfcp-zoom-crop-mark:1512:1512:1512:851.awebp)


## API Reference

#### Create Short Url

```http
  POST /api/url
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `url` | `string` | **Required**. Url that needs to be shortned.|

#### Redirect to Original Url from short Url.

```http
  GET /${key}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `key`      | `string` | **Required**. Id of original Url that needs to be fetched.|

```http
  GET /${key}/details
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `key`      | `string` | **Required**. To get All details of the short url generated.|


