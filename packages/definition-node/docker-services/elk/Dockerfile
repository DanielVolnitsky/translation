FROM sebp/elk

#remove default configs
RUN rm /etc/logstash/conf.d/*

ADD /app-log.conf /etc/logstash/conf.d/app-log.conf