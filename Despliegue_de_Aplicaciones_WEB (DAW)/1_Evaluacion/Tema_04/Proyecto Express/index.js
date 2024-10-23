#!/usr/bin/env node
 
const express = require('express')
const app = express()
const port = 8080
 
app.get('/', (request, response) => {
  response.send('Hello from Express!')
})
app.use('/html',express.static(__dirname + "/html"));
 
 
app.listen(port, (err) => {
  console.log(`server is listening on ${port}`)
})