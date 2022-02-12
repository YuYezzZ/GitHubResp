package cn.itcast.hotel.constants;

/**
 * @Auther: yuye
 * @Date: 2022/2/12 - 02 - 12 - 17:05
 * @Description: cn.itcast.hotel.constants
 * @version: 1.0
 */
public enum RabbitMqEnum {
    EXCHANGE_NAME("topic_hotel"),
    QUEUE_INSERT_NAME("topic_hotel"),
    QUEUE_DELETE_NAME("topic_hotel"),
    ROUTING_INSERT_KEY("topic_hotel"),
    ROUTING_DELETE_KEY("topic_hotel");

    private String value;

    RabbitMqEnum(String value) {
        this.value = value;
    }
}
