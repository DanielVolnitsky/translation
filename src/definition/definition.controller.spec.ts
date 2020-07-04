import { Test, TestingModule } from '@nestjs/testing'
import { HttpModule } from '@nestjs/common'
import { AxiosResponse } from 'axios'
import { DefinitionController } from './definition.controller'
import { DefinitionService } from './definition.service'
import { GetDefinitionDto } from './definition.dto'

describe('DefinitionController', () => {
  let controller: DefinitionController
  let service: DefinitionService

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [HttpModule],
      controllers: [DefinitionController],
      providers: [DefinitionService]
    }).compile()

    service = module.get<DefinitionService>(DefinitionService)
    controller = module.get<DefinitionController>(DefinitionController)
  })

  it('should be defined', () => {
    expect(controller).toBeDefined()
  })

  describe('getDefinition', () => {
    it('should return a definitions of cat', async () => {
      const result: AxiosResponse = {
        data: {
          definitions: [
            {
              type: 'noun',
              definition: 'some definition',
              example: 'their pet cat',
              image_url: 'url.jpg',
              emoji: '🐈'
            }
          ],
          word: 'cat',
          pronunciation: null
        },
        status: 200,
        statusText: 'OK',
        headers: {},
        config: {}
      }

      jest
        .spyOn(service, 'getDefinition')
        .mockImplementation(
          (): Promise<AxiosResponse<GetDefinitionDto>> =>
            Promise.resolve<AxiosResponse<GetDefinitionDto>>(result)
        )

      expect(await controller.getDefinition('cat')).toBe(result.data)
    })
  })
})
