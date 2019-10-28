from datetime import date
import requests
#'https://www.jornada.unam.mx/ultimas',
links = ['http://elfinanciero.com.mx/','https://www.eleconomista.com.mx/','http://www.eluniversal.com.mx/','http://www.excelsior.com.mx/'
         ,'https://elpais.com/','https://www.nytimes.com/','https://www.proceso.com.mx/','http://www.asiatoday.com/','http://www.northkoreatimes.com/'
         ,'https://actualidad.rt.com/','https://mundo.sputniknews.com/']
now = date.today()
print(now)

for link in links:
    response = requests.get(link,stream=True)
    print(response.encoding)
    filename = link.replace('www.','').replace('http://','').replace('https://','').replace('.com.mx/','').replace('.com/','')
    endfilename = ''.join([now.strftime("_%H%d%m%y_"),'raw','.html'])
    print(filename+endfilename)                
    f = open(filename+endfilename,'w',encoding=response.encoding)
    f.writelines(response.text)
    #print(response.text)
    f.close()

