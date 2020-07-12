import { Injectable, HttpService } from '@nestjs/common'
import { AxiosResponse } from 'axios'
import { getApiBaseHeader } from '../config/utils'
import { apiBaseUrl } from '../config/constants'
import { GetDefinitionDto } from './definition.dto'

@Injectable()
export class DefinitionService {
  constructor(private httpService: HttpService) {}
  getDefinition(word: string): Promise<AxiosResponse<GetDefinitionDto>> {
    return this.httpService
      .get(`${apiBaseUrl}${word}`, getApiBaseHeader())
      .toPromise<AxiosResponse<GetDefinitionDto>>()
  }
}
