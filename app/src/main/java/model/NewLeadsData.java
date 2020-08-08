package model;

import java.util.List;

public class NewLeadsData {


    /**
     * status : true
     * data : [{"id":281,"order_id":"202008281","amount":"499","unit":"1","service_date":"2020-08-04","service_time":"12 PM - 04 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":279,"order_id":"202008279","amount":"400","unit":"1","service_date":"2020-08-04","service_time":"12 PM - 04 PM","fault":"AC/Water Service/Split AC","commission":"100","customerDetails":{"id":14,"name_prefix":null,"firstname":"tulsibhati","lastname":null,"dob":null,"contact_no":"9829863201","img":null,"latitude":"27.2039615","longitude":"73.730317","address_street":null,"address_type":null,"address":"Unnamed Road, Ghosiwara, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"14","register_from":"1","created_at":"Jul 12 2020 15:21","updated_at":"Jul 12 2020 15:21"}},{"id":274,"order_id":"202008274","amount":"150","unit":"1","service_date":"2020-08-01","service_time":"04 PM - 08 PM","fault":"Electrician/Installation/Tubelights Installation","commission":"0","customerDetails":{"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}},{"id":273,"order_id":"202008237","amount":"100","unit":"1","service_date":"2020-08-01","service_time":"04 PM - 08 PM","fault":"Water Purifier/RO, UV Purifier/Service or Filter Change","commission":"0","customerDetails":{"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}},{"id":233,"order_id":"202008233","amount":"220","unit":"1","service_date":"2020-08-03","service_time":"12 PM - 04 PM","fault":"Water Purifier/RO, UV Purifier/Service or Filter Change","commission":"40","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":229,"order_id":"202008229","amount":"200","unit":"1","service_date":"2020-08-02","service_time":"08 AM - 12 PM","fault":"Water Purifier/RO, UV Purifier/Repair","commission":"40","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":230,"order_id":"202008230","amount":"280","unit":"1","service_date":"2020-08-02","service_time":"08 AM - 12 PM","fault":"Washing Machine/Top Load Repair/Semi Auto Repair","commission":"50","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":223,"order_id":"202007223","amount":"200","unit":"1","service_date":"2020-08-02","service_time":"12 PM - 04 PM","fault":"AC/Repair/Split AC Repair","commission":"50","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":224,"order_id":"202007224","amount":"200","unit":"1","service_date":"2020-08-02","service_time":"12 PM - 04 PM","fault":"Refrigerator/Single Door/Single Door Repair","commission":"50","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":221,"order_id":"202007221","amount":"897","unit":"3","service_date":"2020-07-31","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Window AC","commission":250,"customerDetails":{"id":24,"name_prefix":null,"firstname":"Pawan","lastname":null,"dob":null,"contact_no":"7229919933","img":null,"latitude":"26.90477509999999","longitude":"75.74886409999999","address_street":null,"address_type":null,"address":"Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"24","register_from":"0","created_at":"Jul 15 2020 08:45","updated_at":"Jul 30 2020 04:09"}},{"id":187,"order_id":"202007187","amount":"598","unit":"2","service_date":"2020-07-27","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":200,"customerDetails":{"id":29,"name_prefix":null,"firstname":"CHAKRADHARI YADAV","lastname":null,"dob":null,"contact_no":"7976431804","img":null,"latitude":"26.8547183","longitude":"75.6456176","address_street":null,"address_type":null,"address":"Unnamed Road, Sarangpura, Rajasthan 302026, India","city":"Sarangpura","state":"Rajasthan","country_code":null,"country":"India","user_id":"29","register_from":"1","created_at":"Jul 17 2020 14:49","updated_at":"Jul 17 2020 14:49"}},{"id":186,"order_id":"202007186","amount":"499","unit":"1","service_date":"2020-07-26","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":16,"name_prefix":null,"firstname":"surendra kumar","lastname":null,"dob":null,"contact_no":"9521159082","img":null,"latitude":"26.8837667","longitude":"75.7819036","address_street":null,"address_type":null,"address":"C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"16","register_from":"1","created_at":"Jul 12 2020 17:21","updated_at":"Jul 13 2020 11:38"}},{"id":183,"order_id":"202007183","amount":"450","unit":"2","service_date":"2020-07-26","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Hot and Cold Water Mixer Repair","commission":0,"customerDetails":{"id":6,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9460278000","img":null,"latitude":"26.8591136","longitude":"75.6702772","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"6","register_from":"1","created_at":"Jul 10 2020 21:59","updated_at":"Jul 10 2020 21:59"}},{"id":180,"order_id":"202007180","amount":"350","unit":"1","service_date":"2020-07-26","service_time":"08 AM - 12 PM","fault":"Washing Machine/Front Load Repair/Front Load Repair","commission":"0","customerDetails":{"id":6,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9460278000","img":null,"latitude":"26.8591136","longitude":"75.6702772","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"6","register_from":"1","created_at":"Jul 10 2020 21:59","updated_at":"Jul 10 2020 21:59"}},{"id":170,"order_id":"202007170","amount":"250","unit":"1","service_date":"2020-07-24","service_time":"04 PM - 08 PM","fault":"Water Tank Cleaning/Plastic Tank/Upto 1000 Ltr.","commission":"100","customerDetails":{"id":6,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9460278000","img":null,"latitude":"26.8591136","longitude":"75.6702772","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"6","register_from":"1","created_at":"Jul 10 2020 21:59","updated_at":"Jul 10 2020 21:59"}},{"id":178,"order_id":"202007178","amount":"598","unit":"2","service_date":"2020-07-25","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":200,"customerDetails":{"id":19,"name_prefix":null,"firstname":"Sunil khoja","lastname":null,"dob":null,"contact_no":"6376573720","img":null,"latitude":"26.8586757","longitude":"75.6701426","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"19","register_from":"1","created_at":"Jul 13 2020 09:25","updated_at":"Jul 13 2020 09:25"}},{"id":177,"order_id":"202007177","amount":"500","unit":"3","service_date":"2020-07-25","service_time":"08 AM - 12 PM","fault":"Water Tank Cleaning/Plastic Tank/Upto 1000 Ltr.","commission":250,"customerDetails":{"id":59,"name_prefix":null,"firstname":"gigraj","lastname":null,"dob":null,"contact_no":"9983987766","img":null,"latitude":"27.6471758","longitude":"75.2429837","address_street":null,"address_type":null,"address":"Piprali Rd, Piprali, Rajasthan 332027, India","city":"Piprali","state":"Rajasthan","country_code":null,"country":"India","user_id":"59","register_from":"1","created_at":"Jul 21 2020 10:14","updated_at":"Jul 21 2020 10:14"}},{"id":173,"order_id":"202007173","amount":"250","unit":"2","service_date":"2020-07-25","service_time":"08 AM - 12 PM","fault":"Electrician/Repair/Board Repair (upto 5 Switch)","commission":0,"customerDetails":{"id":59,"name_prefix":null,"firstname":"gigraj","lastname":null,"dob":null,"contact_no":"9983987766","img":null,"latitude":"27.6471758","longitude":"75.2429837","address_street":null,"address_type":null,"address":"Piprali Rd, Piprali, Rajasthan 332027, India","city":"Piprali","state":"Rajasthan","country_code":null,"country":"India","user_id":"59","register_from":"1","created_at":"Jul 21 2020 10:14","updated_at":"Jul 21 2020 10:14"}},{"id":165,"order_id":"202007165","amount":"200","unit":"1","service_date":"2020-07-23","service_time":"12 PM - 04 PM","fault":"Kitchen Chimney/Wall Mounted Chimney/Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":169,"order_id":"202007169","amount":"400","unit":"2","service_date":"2020-07-24","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":0,"customerDetails":{"id":12,"name_prefix":null,"firstname":"Saveen","lastname":null,"dob":null,"contact_no":"9667393475","img":null,"latitude":"26.8708346","longitude":"75.69726659999999","address_street":null,"address_type":null,"address":"Bhankrota, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"12","register_from":"0","created_at":"Jul 12 2020 10:49","updated_at":"Jul 23 2020 12:14"}},{"id":163,"order_id":"202007163","amount":"598","unit":"2","service_date":"2020-07-23","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":200,"customerDetails":{"id":66,"name_prefix":null,"firstname":"Krishna Digital Group","lastname":null,"dob":null,"contact_no":"6377905873","img":null,"latitude":"26.5264254","longitude":"73.9762076","address_street":null,"address_type":null,"address":"Badgaon Road, Badgaon, Rajasthan 341510, India","city":"Badgaon","state":"Rajasthan","country_code":null,"country":"India","user_id":"66","register_from":"1","created_at":"Jul 22 2020 13:21","updated_at":"Jul 22 2020 13:21"}},{"id":131,"order_id":"202007131","amount":"200","unit":"1","service_date":"2020-07-22","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":115,"order_id":"202007115","amount":"0","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Electrician/Installation/Fan Installation","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":111,"order_id":"202007111","amount":"0","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Plumber/Installation/Washbasin and Sink","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":112,"order_id":"202007112","amount":"0","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Plumber/Installation/Tap, Mixer & Shower","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":113,"order_id":"202007113","amount":"0","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Plumber/Installation/Indian Toilet","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":114,"order_id":"202007114","amount":"0","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Plumber/Installation/Mirror Installation","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":100,"order_id":"202007100","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"04 PM - 08 PM","fault":"Plumber/Repair/Washbasin","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":101,"order_id":"202007101","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"04 PM - 08 PM","fault":"Plumber/Repair/Tap Repair and Replace","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":102,"order_id":"202007102","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"04 PM - 08 PM","fault":"Plumber/Repair/Flush Tank Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":96,"order_id":"20200796","amount":"200","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":87,"order_id":"20200787","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"AC/Repair/Window AC Repair","commission":"50","customerDetails":{"id":52,"name_prefix":null,"firstname":"vijay maanju","lastname":null,"dob":null,"contact_no":"9024110015","img":null,"latitude":"26.6253485","longitude":"75.0364723","address_street":null,"address_type":null,"address":"Mundoti Rd, Bandar Seendri, Rajasthan 305816, India","city":"Bandar Seendri","state":"Rajasthan","country_code":null,"country":"India","user_id":"52","register_from":"1","created_at":"Jul 19 2020 12:19","updated_at":"Jul 19 2020 12:19"}},{"id":84,"order_id":"20200784","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Washbasin","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":85,"order_id":"20200785","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Tap Repair and Replace","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":80,"order_id":"20200780","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":81,"order_id":"20200781","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Washbasin","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":82,"order_id":"20200782","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Tap Repair and Replace","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":83,"order_id":"20200783","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"Plumber/Repair/Flush Tank Repair","commission":"0","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":72,"order_id":"20200772","amount":"200","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":4,"name_prefix":null,"firstname":"mohit","lastname":null,"dob":null,"contact_no":"8130824151","img":null,"latitude":"0.0","longitude":"0.0","address_street":null,"address_type":null,"address":null,"city":null,"state":null,"country_code":null,"country":null,"user_id":"4","register_from":"1","created_at":"Jul 10 2020 14:11","updated_at":"Jul 10 2020 14:11"}},{"id":71,"order_id":"20200771","amount":"500","unit":"1","service_date":"2020-07-19","service_time":"04 PM - 08 PM","fault":"Car Wash Service/Car Sedan/Water Cleaning","commission":"0","customerDetails":{"id":9,"name_prefix":null,"firstname":"hanny banny","lastname":null,"dob":null,"contact_no":"6375859495","img":null,"latitude":"26.8588217","longitude":"75.6702556","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"9","register_from":"1","created_at":"Jul 12 2020 08:04","updated_at":"Jul 22 2020 05:44"}},{"id":65,"order_id":"20200765","amount":"800","unit":"1","service_date":"2020-07-19","service_time":"08 AM - 12 PM","fault":"AC/Installation/Window AC Installation","commission":"200","customerDetails":{"id":39,"name_prefix":null,"firstname":"Pawan Prajapati","lastname":null,"dob":null,"contact_no":"7737395108","img":null,"latitude":"26.90477509999999","longitude":"75.74886409999999","address_street":null,"address_type":null,"address":"Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"39","register_from":"0","created_at":"Jul 18 2020 12:35","updated_at":"Jul 18 2020 12:35"}},{"id":62,"order_id":"20200762","amount":"200","unit":"1","service_date":"2020-07-19","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":24,"name_prefix":null,"firstname":"Pawan","lastname":null,"dob":null,"contact_no":"7229919933","img":null,"latitude":"26.90477509999999","longitude":"75.74886409999999","address_street":null,"address_type":null,"address":"Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"24","register_from":"0","created_at":"Jul 15 2020 08:45","updated_at":"Jul 30 2020 04:09"}},{"id":60,"order_id":"20200760","amount":"400","unit":"2","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"AC/Repair/Split AC Repair","commission":0,"customerDetails":{"id":24,"name_prefix":null,"firstname":"Pawan","lastname":null,"dob":null,"contact_no":"7229919933","img":null,"latitude":"26.90477509999999","longitude":"75.74886409999999","address_street":null,"address_type":null,"address":"Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"24","register_from":"0","created_at":"Jul 15 2020 08:45","updated_at":"Jul 30 2020 04:09"}},{"id":58,"order_id":"20200758","amount":"300","unit":"1","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"Water Tank Cleaning/Plastic Tank/Upto 1000 Ltr.","commission":"50","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":57,"order_id":"20200757","amount":"598","unit":"2","service_date":"2020-07-19","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Split AC","commission":200,"customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":56,"order_id":"20200756","amount":"499","unit":"1","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":31,"name_prefix":null,"firstname":"Rameswaroop Bishnoi","lastname":null,"dob":null,"contact_no":"7726983736","img":null,"latitude":"26.2223456","longitude":"73.0255846","address_street":null,"address_type":null,"address":"A-113, Karni Nagar, करनी नगर, Karni Nagar, Krishna Nagar, Jodhpur, Rajasthan 342005, India","city":"Jodhpur","state":"Rajasthan","country_code":null,"country":"India","user_id":"31","register_from":"1","created_at":"Jul 18 2020 08:14","updated_at":"Jul 18 2020 08:14"}},{"id":54,"order_id":"20200754","amount":"399","unit":"1","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":55,"order_id":"20200755","amount":"399","unit":"1","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Window AC","commission":"200","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":53,"order_id":"20200753","amount":"800","unit":"1","service_date":"2020-07-18","service_time":"04 PM - 08 PM","fault":"Water Tank Cleaning/Cement Tank/5000 - 10000 Ltr.","commission":"300","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":43,"order_id":"20200743","amount":"0","unit":"1","service_date":"2020-07-17","service_time":"12 PM - 04 PM","fault":"Beauty Salon at Home/Facial/Bleach","commission":"0","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":52,"order_id":"20200752","amount":"748","unit":"3","service_date":"2020-07-18","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":250,"customerDetails":{"id":29,"name_prefix":null,"firstname":"CHAKRADHARI YADAV","lastname":null,"dob":null,"contact_no":"7976431804","img":null,"latitude":"26.8547183","longitude":"75.6456176","address_street":null,"address_type":null,"address":"Unnamed Road, Sarangpura, Rajasthan 302026, India","city":"Sarangpura","state":"Rajasthan","country_code":null,"country":"India","user_id":"29","register_from":"1","created_at":"Jul 17 2020 14:49","updated_at":"Jul 17 2020 14:49"}},{"id":48,"order_id":"20200748","amount":"399","unit":"1","service_date":"2020-07-18","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":41,"order_id":"20200741","amount":"100","unit":"1","service_date":"2020-07-17","service_time":"08 AM - 12 PM","fault":"Water Purifier/RO, UV Purifier/Service or Filter Change","commission":"0","customerDetails":{"id":27,"name_prefix":null,"firstname":"Shankar Nayak","lastname":null,"dob":null,"contact_no":"919610899646","img":null,"latitude":"26.9201081","longitude":"75.7380524","address_street":null,"address_type":null,"address":"Sirsi Road, RFC Colony, Hanuman Nagar Extension, Krishna Nagar, Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"27","register_from":"0","created_at":"Jul 16 2020 15:25","updated_at":"Jul 16 2020 15:25"}},{"id":40,"order_id":"20200740","amount":"250","unit":"1","service_date":"2020-07-17","service_time":"08 AM - 12 PM","fault":"Refrigerator/Double Door/double Door Repair","commission":"0","customerDetails":{"id":2,"name_prefix":null,"firstname":"Sanjay Saini","lastname":null,"dob":null,"contact_no":"9460238000","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"2","register_from":"1","created_at":"Jul 10 2020 12:48","updated_at":"Jul 10 2020 12:48"}},{"id":37,"order_id":"20200737","amount":"400","unit":"1","service_date":"2020-07-16","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Split AC","commission":"200","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":30,"order_id":"20200730","amount":"700","unit":"2","service_date":"2020-07-15","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Split AC","commission":200,"customerDetails":{"id":24,"name_prefix":null,"firstname":"Pawan","lastname":null,"dob":null,"contact_no":"7229919933","img":null,"latitude":"26.90477509999999","longitude":"75.74886409999999","address_street":null,"address_type":null,"address":"Vaishali Nagar, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"24","register_from":"0","created_at":"Jul 15 2020 08:45","updated_at":"Jul 30 2020 04:09"}},{"id":17,"order_id":"20200717","amount":"0","unit":"1","service_date":"2020-07-14","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","commission":"0","customerDetails":{"id":16,"name_prefix":null,"firstname":"surendra kumar","lastname":null,"dob":null,"contact_no":"9521159082","img":null,"latitude":"26.8837667","longitude":"75.7819036","address_street":null,"address_type":null,"address":"C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"16","register_from":"1","created_at":"Jul 12 2020 17:21","updated_at":"Jul 13 2020 11:38"}},{"id":10,"order_id":"20200710","amount":"1100","unit":"2","service_date":"2020-07-13","service_time":"08 AM - 12 PM","fault":"AC/Installation/","commission":0,"customerDetails":{"id":31,"name_prefix":null,"firstname":"Rameswaroop Bishnoi","lastname":null,"dob":null,"contact_no":"7726983736","img":null,"latitude":"26.2223456","longitude":"73.0255846","address_street":null,"address_type":null,"address":"A-113, Karni Nagar, करनी नगर, Karni Nagar, Krishna Nagar, Jodhpur, Rajasthan 342005, India","city":"Jodhpur","state":"Rajasthan","country_code":null,"country":"India","user_id":"31","register_from":"1","created_at":"Jul 18 2020 08:14","updated_at":"Jul 18 2020 08:14"}}]
     */

    private boolean status;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 281
         * order_id : 202008281
         * amount : 499
         * unit : 1
         * service_date : 2020-08-04
         * service_time : 12 PM - 04 PM
         * fault : AC/Water Service/Split AC
         * commission : 200
         * customerDetails : {"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}
         */

        private int id;
        private String order_id;
        private String amount;
        private String unit;
        private String service_date;
        private String service_time;
        private String fault;
        private String commission;

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        private String booking_date;
        private CustomerDetailsBean customerDetails;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getService_date() {
            return service_date;
        }

        public void setService_date(String service_date) {
            this.service_date = service_date;
        }

        public String getService_time() {
            return service_time;
        }

        public void setService_time(String service_time) {
            this.service_time = service_time;
        }

        public String getFault() {
            return fault;
        }

        public void setFault(String fault) {
            this.fault = fault;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public CustomerDetailsBean getCustomerDetails() {
            return customerDetails;
        }

        public void setCustomerDetails(CustomerDetailsBean customerDetails) {
            this.customerDetails = customerDetails;
        }

        public static class CustomerDetailsBean {
            /**
             * id : 7
             * name_prefix : null
             * firstname : md
             * lastname : null
             * dob : null
             * contact_no : 9252279720
             * img : null
             * latitude : 26.8590022
             * longitude : 75.6703667
             * address_street : null
             * address_type : null
             * address : Mahapura, Rajasthan 302026, India
             * city : null
             * state : Rajasthan
             * country_code : null
             * country : India
             * user_id : 7
             * register_from : 1
             * created_at : Jul 11 2020 19:43
             * updated_at : Jul 11 2020 19:43
             */

            private int id;
            private Object name_prefix;
            private String firstname;
            private Object lastname;
            private Object dob;
            private String contact_no;
            private Object img;
            private String latitude;
            private String longitude;
            private Object address_street;
            private Object address_type;
            private String address;
            private Object city;
            private String state;
            private Object country_code;
            private String country;
            private String user_id;
            private String register_from;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getName_prefix() {
                return name_prefix;
            }

            public void setName_prefix(Object name_prefix) {
                this.name_prefix = name_prefix;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public Object getLastname() {
                return lastname;
            }

            public void setLastname(Object lastname) {
                this.lastname = lastname;
            }

            public Object getDob() {
                return dob;
            }

            public void setDob(Object dob) {
                this.dob = dob;
            }

            public String getContact_no() {
                return contact_no;
            }

            public void setContact_no(String contact_no) {
                this.contact_no = contact_no;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public Object getAddress_street() {
                return address_street;
            }

            public void setAddress_street(Object address_street) {
                this.address_street = address_street;
            }

            public Object getAddress_type() {
                return address_type;
            }

            public void setAddress_type(Object address_type) {
                this.address_type = address_type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public Object getCountry_code() {
                return country_code;
            }

            public void setCountry_code(Object country_code) {
                this.country_code = country_code;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getRegister_from() {
                return register_from;
            }

            public void setRegister_from(String register_from) {
                this.register_from = register_from;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
