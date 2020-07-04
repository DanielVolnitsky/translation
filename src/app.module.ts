import { Module } from '@nestjs/common'
import { ConfigModule } from '@nestjs/config'
import { DefinitionModule } from './definition/definition.module'
import { AppController } from './app.controller'
import { AppService } from './app.service'

@Module({
  imports: [
    ConfigModule.forRoot({
      envFilePath: '.env',
      isGlobal: true
    }),
    DefinitionModule
  ],
  controllers: [AppController],
  providers: [AppService]
})
export class AppModule {}
