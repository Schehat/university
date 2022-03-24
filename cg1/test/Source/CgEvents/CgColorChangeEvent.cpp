#include "CgColorChangeEvent.h"

CgColorChangeEvent::CgColorChangeEvent()
{

}

CgColorChangeEvent::CgColorChangeEvent(Cg::EventType type, std::string text, int red, int green, int blue)
{
    m_type = type;
    m_text = text;
    m_red = red;
    m_green = green;
    m_blue = blue;
}

CgColorChangeEvent::~CgColorChangeEvent()
{

}

Cg::EventType  CgColorChangeEvent::getType()
{
    return m_type;
}

CgBaseEvent* CgColorChangeEvent::clone()
{
    return new CgColorChangeEvent(m_type, m_text, m_red, m_green, m_blue);
}

std::string CgColorChangeEvent::text() const
{
    return m_text;
}

std::ostream& operator<<(std::ostream& os,const CgColorChangeEvent& e)
{
    os << "Type: "<< e.m_type << " Colors: ";
    return os;
}

