import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

// const express = require('express')
// const cors = require('cors')
// const app = express()
//
// app.use(cors())
//
// app.listen(80, function () {
//   console.log('CORS-enabled web server listening on port 80')
// })
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
