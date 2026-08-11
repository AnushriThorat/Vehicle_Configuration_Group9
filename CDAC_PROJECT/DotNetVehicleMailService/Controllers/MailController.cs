using Microsoft.AspNetCore.Mvc;
using VehicleMailService.DTOs;
using VehicleMailService.Interfaces;

namespace VehicleMailService.Controllers
{
    [ApiController]
    [Route("api/mail")]
    public class MailController : ControllerBase
    {
        private readonly IMailService _mailService;

        public MailController(IMailService mailService)
        {
            _mailService = mailService;
        }

        [HttpPost("send-invoice")]
        public async Task<IActionResult> SendInvoice(
            [FromBody] MailRequestDto request)
        {
            try
            {
                byte[] pdf =
                    Convert.FromBase64String(request.Pdf);

                await _mailService.SendInvoiceMail(
                    request.Email,
                    request.Subject,
                    request.Body,
                    pdf,
                    request.FileName);

                return Ok("Mail Sent Successfully");
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }
    }
}